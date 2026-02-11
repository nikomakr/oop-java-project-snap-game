import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Option 2 CLEANEST: Enhanced Terminal - Shows countdown, then prompts for input
 * Avoids all the visual mess by separating countdown from typing
 */
public class SnapTerminal {
    
    private static String userInput = "";
    private static boolean timeExpired = false;
    private static Scanner scanner = new Scanner(System.in);
    
    public static String showSnapTerminal() {
        userInput = "";
        timeExpired = false;
        
        System.out.println("\n╔════════════════════════════════╗");
        System.out.println("║     *** MATCH FOUND! ***       ║");
        System.out.println("║  Type 'snap' within 2 seconds!  ║");
        System.out.println("╚════════════════════════════════╝\n");
        
        // Visual countdown bar
        System.out.print("⏱️  [");
        
        Timer countdownTimer = new Timer();
        final int[] beatsLeft = {20};  // 20 beats × 100ms = 2000ms
        
        countdownTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                beatsLeft[0]--;
                
                if (beatsLeft[0] > 0) {
                    System.out.print("█");  // Progress bar
                    System.out.flush();
                } else {
                    timeExpired = true;
                    countdownTimer.cancel();
                    System.out.println("] TIME'S UP!\n");
                }
            }
        }, 100, 100);  // Every 100ms
        
        // Prompt for input AFTER countdown starts
        try {
            Thread.sleep(100);  // Small delay so user sees the prompt
        } catch (InterruptedException e) {
            // Ignore
        }
        
        System.out.print("\n\nType 'snap': ");
        System.out.flush();
        
        // Wait for input with timeout
        while (!timeExpired && userInput.isEmpty()) {
            if (scanner.hasNextLine()) {
                userInput = scanner.nextLine().trim().toLowerCase();
                break;
            }
            
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // Ignore
            }
        }
        
        countdownTimer.cancel();
        
        // Clean up the progress bar if user typed in time
        if (!timeExpired) {
            // Fill remaining spaces
            for (int i = beatsLeft[0]; i > 0; i--) {
                System.out.print("█");
            }
            System.out.println("] DONE!\n");
        }
        
        return userInput;
    }
    
    // Test the terminal version
    public static void main(String[] args) {
        System.out.println("Testing Enhanced Terminal with Countdown...");
        
        String result = showSnapTerminal();
        
        if (result.isEmpty()) {
            System.out.println("❌ Time expired! No input received.");
        } else {
            System.out.println("You typed: " + result);
            if (result.equals("snap")) {
                System.out.println("✅ CORRECT! Player wins!");
            } else {
                System.out.println("❌ Wrong input!");
            }
        }
    }
}