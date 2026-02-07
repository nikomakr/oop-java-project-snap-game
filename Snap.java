import java.util.Scanner;

/**
 * Snap card game - single player version.
 * Extends CardGame to inherit deck management functionality.
 * Player presses Enter to deal cards until two consecutive cards match.
 */
public class Snap extends CardGame {
    private Card previousCard;  // The last card that was dealt
    private Card currentCard;   // The current card just dealt
    private Scanner scanner;    // For reading user input

    /**
     * Constructor for Snap game.
     * Initializes the game and shuffles the deck.
     */
    public Snap() {
        super("Snap");  // Call parent constructor with game name
        this.scanner = new Scanner(System.in);
        this.previousCard = null;
        this.currentCard = null;
        shuffleDeck();  // Start with a shuffled deck
    }

    /**
     * Plays the Snap game.
     * Player presses Enter to deal cards until two consecutive cards match symbols.
     */
    public void play() {
        System.out.println("=== Snap Time! ===");
        System.out.println("Press Enter to deal cards. It's SNAP after all!");
        System.out.println("Win by getting two cards with the same number or symbol in a row!\n");

        boolean isGameWon = false;
        int turnCount = 0;

        while (!isGameWon && getDeckOfCards().size() > 0) {
            // Wait for player to press Enter
            System.out.print("Press Enter to deal a card... ");
            scanner.nextLine();

            // Deal a card
            currentCard = dealCard();
            turnCount++;

            if (currentCard == null) {
                System.out.println("No more cards in the deck! Game over.");
                break;
            }

            System.out.println("Turn " + turnCount + ": " + currentCard);

            // Check for a match (after at least one card has been dealt)
            if (previousCard != null) {
                if (currentCard.getSymbol().equals(previousCard.getSymbol())) {
                    System.out.println("\nSnapie 🎉 SNAP! 🎉 Snap!");
                    System.out.println("Two " + currentCard.getSymbol() + "s in a row!");
                    System.out.println("You won just after " + turnCount + " turns!");
                    isGameWon = true;
                }
            }

            // Update previous card for next turn
            previousCard = currentCard;
        }

        if (!isGameWon && getDeckOfCards().size() == 0) {
            System.out.println("\nDeck is empty. No snap found. Game over!");
        }

        scanner.close();
    }

    /**
     * Main method to run the Snap game.
     */
    public static void main(String[] args) {
        Snap game = new Snap();
        game.play();
    }
}