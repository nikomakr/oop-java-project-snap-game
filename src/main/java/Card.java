package src.main.java;
public class Card { //not sure about the private, below:
    private String suit; // e.g., "Hearts", "Diamonds", "Clubs", "Spades" aka "♥", "♦", "♣", "♠"
    private String symbol; // 2,3,4,5,6,7,8,9,10,J,Q,K,A
    private int value; // 2-10 for numbered cards, 10 for J,Q,K, 11 for A


// Constructor to create a new Card
public Card(String suit, String symbol, int value) {
    this.suit = suit;
    this.symbol = symbol;
    this.value = value;
}

// Returns the suit of the card aka "♥", "♦", "♣", "♠"
public String getSuit() {
    return suit;
}

// Returns the symbol of the card aka 2,3,4,5,6,7,8,9,10,J,Q,K,A
public String getSymbol() {
    return symbol;
}

// Returns the value of the card 2-10 for numbered cards, 10 for J,Q,K, 11 for A
public int getValue() {
    return value;
}

// Returns a string representation of the card, symbol + suit like "A♠" for Ace of Spades
public String toString() {
    return symbol + suit;
}

// Main method (mandatory to any Java class)
public static void main(String[] args) {
        // Create some test cards
        Card aceOfHearts = new Card("♥", "A", 14);
        Card tenOfSpades = new Card("♠", "10", 10);
        Card kingOfClubs = new Card("♣", "K", 13);

        // Test the toString method
        System.out.println("Test Card 1: " + aceOfHearts);
        System.out.println("Test Card 2: " + tenOfSpades);
        System.out.println("Test Card 3: " + kingOfClubs);

        // Test the getter methods
        System.out.println("\nCard details:");
        System.out.println("Suit: " + aceOfHearts.getSuit());
        System.out.println("Symbol: " + aceOfHearts.getSymbol());
        System.out.println("Value: " + aceOfHearts.getValue());
    }
}