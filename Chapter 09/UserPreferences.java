import java.util.Scanner;

public class UserPreferences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your preferred music genre: ");
        String genre = scanner.nextLine();

        System.out.print("How many songs do you listen to daily? ");
        int dailySongs = scanner.nextInt();

        System.out.print("Do you prefer high-quality streaming? (true/false) ");
        boolean highQuality = scanner.nextBoolean();

        System.out.println("\nUser Preferences:");
        System.out.println("Genre: " + genre);
        System.out.println("Daily Songs: " + dailySongs);
        System.out.println("High-Quality Streaming: " + highQuality);

        scanner.close();
    }
}
