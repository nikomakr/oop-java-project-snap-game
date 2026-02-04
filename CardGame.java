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

    // Returns 
    public Card dealCard() {
        if (deckOfCards.isEmpty()) {
            System.out.println("The deck is empty! No more cards to deal.");
            return null; // No cards left to deal
        }
        return deckOfCards.remove(0); // Remove and return the top card, index 0 = top of the deck
    }

public static void main(String[] args) {
    CardGame game = new CardGame("Poker");
    
    System.out.println("Initial deck size: " + game.getDeckOfCards().size());
    
    // Deal 3 cards
    Card card1 = game.dealCard();
    Card card2 = game.dealCard();
    Card card3 = game.dealCard();
    
    System.out.println("Dealt card 1: " + card1);
    System.out.println("Dealt card 2: " + card2);
    System.out.println("Dealt card 3: " + card3);
    System.out.println("Remaining cards in deck: " + game.getDeckOfCards().size());
}
}
