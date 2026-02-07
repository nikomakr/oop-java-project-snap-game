/**
 * Represents a player in the Snap card game.
 * Each player has a name and can track their score/wins.
 */
public class Player {
    private String name;        // Player's name
    private int wins;           // Number of games won

    /**
     * Constructor to create a new Player.
     * 
     * @param name The player's name
     */
    public Player(String name) {
        this.name = name;
        this.wins = 0;
    }

    /**
     * Returns the player's name.
     * 
     * @return The player's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the number of wins.
     * 
     * @return The number of games this player has won
     */
    public int getWins() {
        return wins;
    }

    /**
     * Increments the win count for this player.
     */
    public void addWin() {
        wins++;
    }

    /**
     * Returns a string representation of the player.
     * 
     * @return Player name and win count
     */
    @Override
    public String toString() {
        return name + " (Wins: " + wins + ")";
    }

    /**
     * Main method for testing the Player class.
     */
    public static void main(String[] args) {
        // Create two players
        Player player1 = new Player("Rémi");
        Player player2 = new Player("Ashlee");

        System.out.println("=== Player Test ===");
        System.out.println("Player 1: " + player1);
        System.out.println("Player 2: " + player2);

        // Simulate some wins
        player1.addWin();
        player1.addWin();
        player2.addWin();

        System.out.println("\nAfter some games:");
        System.out.println("Player 1: " + player1);
        System.out.println("Player 2: " + player2);

        System.out.println("\nPlayer class working correctly!");
    }
}