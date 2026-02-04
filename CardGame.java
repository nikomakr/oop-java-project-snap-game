import java.util.ArrayList;

public class CardGame {
    // Variables
    private ArrayList<Card> deckOfCards;
    private String name;

    // Constructor to create a new CardGame
    public CardGame(String name) {
        this.name = name;
        this.deckOfCards = new ArrayList<Card>();
        createDeck();
    }

    // Method to create a standard deck of 52 playing cards
    private void createDeck() {
        String[] suits = {"♠", "♥", "♦", "♣"};
        String[] symbols = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}; // J=11, Q=12, K=13, A=14
        //Create the deck of all 52 cards (4 suits x 13 symbols)
        for (String suit : suits) {
            for (int i = 0; i < symbols.length; i++) {
                Card card = new Card(suit, symbols[i], values[i]);
                deckOfCards.add(card);
            }
        }
    }

    public String getName() {
        return name;
    }
    // Method to display the deck of cards
    public void getDeck() {
        System.out.println("=== " + name + " - Deck of Cards ===");
        System.out.println("Total cards in deck: " + deckOfCards.size());
        System.out.println();
        
        for (int i = 0; i < deckOfCards.size(); i++) {
            System.out.println((i + 1) + ". " + deckOfCards.get(i));
        }
        System.out.println();
    }

    // Returns the deck of cards sublasses can access
    protected ArrayList<Card> getDeckOfCards() {
        return deckOfCards;
    }

    public static void main(String[] args) {
        // Create a new CardGame instance
        CardGame game = new CardGame("Poker");
        // Display the deck of cards
        game.getDeck();
        // 
        System.out.println("Game name: " + game.getName());
        System.out.println("Number of cards: " + game.getDeckOfCards().size());
    }
}
