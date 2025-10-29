import java.util.Scanner;

public class SongRating {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your rating (1-5) for the song: ");
        int rating = scanner.nextInt();

        System.out.println("You rated this song: " + rating + " stars.");

        scanner.close();
    }
}
