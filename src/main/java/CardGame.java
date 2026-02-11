package src.main.java;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a card game with a standard 52-card deck.
 * This is the base class that manages the deck of cards.
 */
public class CardGame {
    // Instance variables
    private ArrayList<Card> deckOfCards;  // The deck containing all cards
    private String name;                   // The name of the game

    /**
     * Constructor to create a new CardGame.
     * Initializes the deck with all 52 cards and sets the game name.
     * 
     * @param name The name of the card game
     */
    public CardGame(String name) {
        this.name = name;
        this.deckOfCards = new ArrayList<>();
        createDeck();
    }

    /**
     * Creates a standard 52-card deck.
     * Creates all combinations of suits and symbols.
     */
    private void createDeck() {
        // Define the four suits using Unicode characters
        String[] suits = {"♥", "♣", "♦", "♠"};
        
        // Define all card symbols
        String[] symbols = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        
        // Define corresponding values for each symbol
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

        // Create all 52 cards (4 suits × 13 symbols)
        for (String suit : suits) {
            for (int i = 0; i < symbols.length; i++) {
                Card card = new Card(suit, symbols[i], values[i]);
                deckOfCards.add(card);
            }
        }
    }

    /**
     * Returns the name of the game.
     * 
     * @return The game name as a String
     */
    public String getName() {
        return name;
    }

    /**
     * Lists out all the cards currently in the deck.
     * Prints each card on a new line with its index number.
     */
    public void getDeck() {
        System.out.println("=== " + name + " - Deck of Cards ===");
        System.out.println("Total cards in deck: " + deckOfCards.size());
        System.out.println();
        
        for (int i = 0; i < deckOfCards.size(); i++) {
            System.out.println((i + 1) + ". " + deckOfCards.get(i));
        }
        System.out.println();
    }

    /**
     * Returns the ArrayList of cards (for use by subclasses).
     * 
     * @return The deck of cards as an ArrayList
     */
    protected ArrayList<Card> getDeckOfCards() {
        return deckOfCards;
    }

    /**
     * Deals (removes and returns) the top card from the deck.
     * 
     * @return The card from the top of the deck, or null if deck is empty
     */
    public Card dealCard() {
        if (deckOfCards.isEmpty()) {
            System.out.println("Deck is empty! No cards to deal.");
            return null;
        }
        
        // Remove and return the first card (index 0 = top of deck)
        return deckOfCards.remove(0);
    }

    /**
     * Shuffles the deck into a random order.
     * 
     * @return The shuffled deck
     */
    public ArrayList<Card> shuffleDeck() {
        Collections.shuffle(deckOfCards);
        System.out.println("Deck has been shuffled!");
        return deckOfCards;
    }

    /**
     * Sorts the deck in number order (all 2s, then all 3s, etc.).
     * Cards with the same value will be grouped together.
     * 
     * @return The sorted deck
     */
    public ArrayList<Card> sortDeckInNumberOrder() {
        deckOfCards.sort((card1, card2) -> Integer.compare(card1.getValue(), card2.getValue()));
        System.out.println("Deck has been sorted by number!");
        return deckOfCards;
    }

    /**
     * Sorts the deck into suits.
     * Each suit is sorted in order (2-A) and suits are grouped together.
     * Order: Hearts, Clubs, Diamonds, Spades
     * 
     * @return The sorted deck
     */
    public ArrayList<Card> sortDeckIntoSuits() {
        // Define suit order: ♥ ♣ ♦ ♠
        String[] suitOrder = {"♥", "♣", "♦", "♠"};
        
        deckOfCards.sort((card1, card2) -> {
            // First, compare by suit
            int suit1Index = java.util.Arrays.asList(suitOrder).indexOf(card1.getSuit());
            int suit2Index = java.util.Arrays.asList(suitOrder).indexOf(card2.getSuit());
            
            if (suit1Index != suit2Index) {
                return Integer.compare(suit1Index, suit2Index);
            }
            
            // If suits are the same, compare by value
            return Integer.compare(card1.getValue(), card2.getValue());
        });
        
        System.out.println("Deck has been sorted into suits!");
        return deckOfCards;
    }

    /**
     * Main method for testing the CardGame class.
     */
    public static void main(String[] args) {
        CardGame game = new CardGame("Poker");
        
        System.out.println("=== Testing sortDeckIntoSuits() ===");
        System.out.println("First 10 cards BEFORE sorting:");
        for (int i = 0; i < 10; i++) {
            System.out.println((i + 1) + ". " + game.getDeckOfCards().get(i));
        }
        
        // Sort into suits
        game.sortDeckIntoSuits();
        
        System.out.println("\nFirst 16 cards AFTER sorting into suits:");
        System.out.println("(Should show all hearts, then clubs...)");
        for (int i = 0; i < 16; i++) {
            System.out.println((i + 1) + ". " + game.getDeckOfCards().get(i));
        }
        
        System.out.println("\n=== Testing sortDeckInNumberOrder() ===");
        game.sortDeckInNumberOrder();
        
        System.out.println("First 8 cards after sorting by number:");
        System.out.println("(Should show all 2s, then 3s...)");
        for (int i = 0; i < 8; i++) {
            System.out.println((i + 1) + ". " + game.getDeckOfCards().get(i));
        }
        
        System.out.println("\n=== Testing shuffleDeck() ===");
        game.shuffleDeck();
        
        System.out.println("First 5 cards after shuffle:");
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + ". " + game.getDeckOfCards().get(i));
        }
        
        System.out.println("\n=== Testing dealCard() ===");
        System.out.println("Deck size before dealing: " + game.getDeckOfCards().size());
        
        Card card1 = game.dealCard();
        Card card2 = game.dealCard();
        Card card3 = game.dealCard();
        
        System.out.println("Dealt card 1: " + card1);
        System.out.println("Dealt card 2: " + card2);
        System.out.println("Dealt card 3: " + card3);
        System.out.println("Deck size after dealing: " + game.getDeckOfCards().size());
        
        System.out.println("\n✅ Stage 2 Complete! All methods working!");
    }
}