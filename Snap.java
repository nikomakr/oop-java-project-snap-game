import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Snap card game - two player version with timer.
 * Extends CardGame to inherit deck management functionality.
 * Players alternate turns dealing cards until two consecutive cards match.
 * When a match occurs, players have 2 seconds to type "snap" to win.
 */
public class Snap extends CardGame {
    private Card previousCard;      // The last card that was dealt
    private Card currentCard;       // The current card just dealt
    private Scanner scanner;        // For reading user input
    private Player player1;         // First player
    private Player player2;         // Second player
    private int currentPlayerIndex; // 0 for player1, 1 for player2
    private boolean timerExpired;   // Flag for when 2-second timer expires
    private String snapResponse;    // Stores player's input during snap opportunity

    /**
     * Constructor for two-player Snap game.
     * Initializes the game with two players and shuffles the deck.
     * 
     * @param player1Name Name of the first player
     * @param player2Name Name of the second player
     */
    public Snap(String player1Name, String player2Name) {
        super("Snap");  // Call parent constructor with game name
        this.scanner = new Scanner(System.in);
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
        this.previousCard = null;
        this.currentCard = null;
        this.currentPlayerIndex = 0;  // Player 1 starts
        this.timerExpired = false;
        this.snapResponse = "";
        shuffleDeck();  // Start with a shuffled deck
    }

    /**
     * Constructor that accepts existing Player objects (for replay with stats).
     * 
     * @param existingPlayer1 Existing player 1 object
     * @param existingPlayer2 Existing player 2 object
     */
    public Snap(Player existingPlayer1, Player existingPlayer2) {
        super("Snap");  // Call parent constructor with game name
        this.scanner = new Scanner(System.in);
        this.player1 = existingPlayer1;
        this.player2 = existingPlayer2;
        this.previousCard = null;
        this.currentCard = null;
        this.currentPlayerIndex = 0;  // Player 1 starts
        this.timerExpired = false;
        this.snapResponse = "";
        shuffleDeck();  // Start with a shuffled deck
    }

    /**
     * Gets the current player based on the turn index.
     * 
     * @return The player whose turn it is
     */
    private Player getCurrentPlayer() {
        return currentPlayerIndex == 0 ? player1 : player2;
    }

    /**
     * Switches to the other player's turn.
     */
    private void switchPlayer() {
        currentPlayerIndex = (currentPlayerIndex == 0) ? 1 : 0;
    }

    /**
     * Plays the two-player Snap game.
     * Players alternate turns dealing cards until two consecutive cards match.
     * When a match occurs, players have 2 seconds to type "snap" to win.
     */
    public void play() {
        System.out.println("=== Snap Time! ===");
        System.out.println("Players: " + player1.getName() + " vs " + player2.getName());
        System.out.println("Press Enter to deal cards. It's SNAP after all!");
        System.out.println("Win by getting two cards with the same number or symbol in a row!");
        System.out.println("When you see a match, type 'snap' within 2 seconds to win!\n");

        boolean isGameWon = false;
        int turnCount = 0;

        while (!isGameWon && getDeckOfCards().size() > 0) {
            Player currentPlayer = getCurrentPlayer();
            
            // Wait for current player to press Enter
            System.out.print(currentPlayer.getName() + "'s turn - Press Enter to deal a card... ");
            scanner.nextLine();

            // Deal a card
            currentCard = dealCard();
            turnCount++;

            if (currentCard == null) {
                System.out.println("No more cards in the deck! Game over.");
                break;
            }

            System.out.println("Turn " + turnCount + " (" + currentPlayer.getName() + "): " + currentCard);

            // Check for a match (after at least one card has been dealt)
            if (previousCard != null) {
                if (currentCard.getSymbol().equals(previousCard.getSymbol())) {
                    System.out.println("\n*** MATCH! Two " + currentCard.getSymbol() + "s! ***");
                    
                    // Start the 2-second timer with PROGRESS BAR
                    timerExpired = false;
                    snapResponse = "";
                    
                    // Show progress bar on its own line
                    System.out.println("\n⏱️  [                    ]");
                    System.out.print("Type 'snap': ");
                    System.out.flush();
                    
                    Timer progressTimer = new Timer();
                    final int[] beatsLeft = {20};  // 20 beats × 100ms = 2000ms
                    
                    progressTimer.scheduleAtFixedRate(new TimerTask() {
                        @Override
                        public void run() {
                            beatsLeft[0]--;
                            
                            if (beatsLeft[0] >= 0) {
                                // Move cursor up, update progress bar, move back down
                                System.out.print("\033[1A");  // Move up 1 line
                                System.out.print("\r⏱️  [");
                                
                                // Print filled blocks
                                for (int i = 0; i < (20 - beatsLeft[0]); i++) {
                                    System.out.print("█");
                                }
                                // Print empty spaces
                                for (int i = 0; i < beatsLeft[0]; i++) {
                                    System.out.print(" ");
                                }
                                System.out.print("]");
                                
                                System.out.print("\033[1B");  // Move down 1 line
                                System.out.print("\rType 'snap': ");
                                System.out.flush();
                            }
                            
                            if (beatsLeft[0] < 0) {
                                timerExpired = true;
                                progressTimer.cancel();
                            }
                        }
                    }, 0, 100);  // Start immediately, update every 100ms
                    
                    // Wait for input with timeout check
                    long startTime = System.currentTimeMillis();
                    while (!timerExpired && snapResponse.isEmpty()) {
                        if (scanner.hasNextLine()) {
                            snapResponse = scanner.nextLine().trim().toLowerCase();
                            break;
                        }
                        
                        // Small sleep to prevent CPU spinning
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            // Ignore
                        }
                    }
                    
                    progressTimer.cancel();
                    long responseTime = System.currentTimeMillis() - startTime;
                    
                    // Clean up display
                    if (timerExpired) {
                        System.out.print("\033[1A");  // Move up
                        System.out.println("\r⏱️  [████████████████████] TIME'S UP!   ");
                        System.out.println();
                    } else {
                        System.out.print("\033[1A");  // Move up
                        System.out.println("\r⏱️  [████████████████████] DONE!        ");
                        System.out.println();
                    }
                    
                    // Check the response
                    if (snapResponse.equals("snap") && !timerExpired) {
                        System.out.println("Snapie 🎉 SNAP! 🎉 Snap!");
                        System.out.println(currentPlayer.getName() + " typed 'snap' in " + responseTime + "ms!");
                        System.out.println(currentPlayer.getName() + " wins this round!");
                        currentPlayer.addWin();
                        
                        // Check if deck is empty
                        if (getDeckOfCards().size() == 0) {
                            System.out.println("\n🎴 Deck is empty! Game over!");
                            isGameWon = true;
                        } else {
                            System.out.println("Cards remaining: " + getDeckOfCards().size());
                            System.out.println("Game continues...\n");
                            // Game continues, don't set isGameWon = true
                        }
                    } else if (timerExpired) {
                        System.out.println("Time's up! Too slow!");
                        System.out.println("Nobody wins this round. Game continues...\n");
                    } else {
                        System.out.println("Wrong input! You needed to type 'snap'!");
                        System.out.println("Nobody wins this round. Game continues...\n");
                    }
                    
                }
            }

            if (!isGameWon) {
                // Update previous card for next turn
                previousCard = currentCard;
                
                // Switch to other player
                switchPlayer();
            }
        }

        if (!isGameWon && getDeckOfCards().size() == 0) {
            System.out.println("\n🎴 Deck is empty. No more snaps possible. Game over!");
        }
        
        // Display final scores
        System.out.println("\n=== Final Scores ===");
        System.out.println(player1);
        System.out.println(player2);
    }

    /**
     * Main method to run the two-player Snap game with replay option.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean playAgain = true;
        
        System.out.println("=== Welcome to Two-Player Snap! ===\n");
        
        System.out.print("Enter Player 1 name: ");
        String name1 = input.nextLine();
        
        System.out.print("Enter Player 2 name: ");
        String name2 = input.nextLine();
        
        // Create player objects once (stats will persist)
        Player player1 = new Player(name1);
        Player player2 = new Player(name2);
        
        while (playAgain) {
            System.out.println();
            
            // Create new game with existing players
            Snap game = new Snap(player1, player2);
            game.play();
            
            // Ask if players want to play again
            System.out.print("\nPlay another game? (Y/N): ");
            String response = input.nextLine().trim().toUpperCase();
            
            if (response.equals("Y") || response.equals("YES")) {
                playAgain = true;
                System.out.println("\n🔄 Starting new game...\n");
            } else {
                playAgain = false;
                System.out.println("\n👋 Thanks for playing! Goodbye!");
                System.out.println("\n=== Overall Statistics ===");
                System.out.println(player1);
                System.out.println(player2);
            }
        }
        
        input.close();
    }
}