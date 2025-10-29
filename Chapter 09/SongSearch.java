import java.util.Scanner;

public class SongSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a song title to search: ");
        String songTitle = scanner.nextLine();

        System.out.println("Searching for: " + songTitle);
        
        scanner.close();
    }
}
