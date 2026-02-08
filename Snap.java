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
    private boolean snapOccurred;   // Flag for when matching cards appear
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
        this.snapOccurred = false;
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
     * Gets the other player (not current turn).
     * 
     * @return The player who is not currently taking a turn
     */
    private Player getOtherPlayer() {
        return currentPlayerIndex == 0 ? player2 : player1;
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
                    System.out.println("Quick! Type 'snap' within 2 seconds!");
                    
                    // Start the 2-second timer
                    snapOccurred = true;
                    timerExpired = false;
                    snapResponse = "";
                    
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            timerExpired = true;
                        }
                    }, 2000); // 2 seconds
                    
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
                    
                    timer.cancel();
                    long responseTime = System.currentTimeMillis() - startTime;
                    
                    // Check the response
                    if (snapResponse.equals("snap") && !timerExpired) {
                        System.out.println("\nSnapie 🎉 SNAP! 🎉 Snap!");
                        System.out.println(currentPlayer.getName() + " typed 'snap' in " + responseTime + "ms!");
                        System.out.println(currentPlayer.getName() + " wins!");
                        currentPlayer.addWin();
                        isGameWon = true;
                    } else if (timerExpired) {
                        System.out.println("\nTime's up! Too slow!");
                        System.out.println("Nobody wins this round. Game continues...\n");
                    } else {
                        System.out.println("\nWrong input! You needed to type 'snap'!");
                        System.out.println("Nobody wins this round. Game continues...\n");
                    }
                    
                    snapOccurred = false;
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
            System.out.println("\nDeck is empty. No snap found. Game over!");
        }
        
        // Display final scores
        System.out.println("\n=== Final Scores ===");
        System.out.println(player1);
        System.out.println(player2);

        scanner.close();
    }

    /**
     * Main method to run the two-player Snap game.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("=== Welcome to Two-Player Snap! ===\n");
        
        System.out.print("Enter Player 1 name: ");
        String name1 = input.nextLine();
        
        System.out.print("Enter Player 2 name: ");
        String name2 = input.nextLine();
        
        System.out.println();
        
        Snap game = new Snap(name1, name2);
        game.play();
        
        input.close();
    }
}