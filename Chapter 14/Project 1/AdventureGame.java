import java.util.Scanner;

public class AdventureGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            playAgain = false; // Reset game state
            System.out.println("\nWelcome to the Command-Line\nText-Based Adventure Game!\n");
            System.out.println("You find yourself in a dark cave.");

            // Room 1
            System.out.println("Room 1: You see two paths. Do you take the left path (A) or the right path (B)?");
            String choice1 = scanner.nextLine().trim().toUpperCase();
            boolean tookLeftPath = choice1.equals("A");

            // Room 2
            System.out.println("Room 2: You find a locked door. Do you knock (A) or look around for a key (B)?");
            String choice2 = scanner.nextLine().trim().toUpperCase();
            boolean foundKey = choice2.equals("B");

            // Room 3
            System.out.println("Room 3: A mysterious figure asks you to solve a riddle.");
            System.out.println("Do you answer truthfully (A) or lie (B)?");
            String choice3 = scanner.nextLine().trim().toUpperCase();
            boolean answeredTruthfully = choice3.equals("A");

            // Determine ending
            if (tookLeftPath && foundKey && answeredTruthfully) {
                System.out.println("Congratulations! The figure rewards your honesty. You escape the cave safely!");
            } else {
                System.out.println("The mysterious figure shakes their head. A trapdoor opens beneath you!");
                System.out.println("Game Over.");
            }

            // Replay option
            System.out.println("Would you like to play again? (yes/no)");
            String replayChoice = scanner.nextLine().trim().toLowerCase();
            if (replayChoice.equals("yes")) {
                playAgain = true;
            }

        } while (playAgain);

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
