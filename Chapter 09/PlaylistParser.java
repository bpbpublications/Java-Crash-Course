import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PlaylistParser {
    public static void main(String[] args) {
        try {
            File file = new File("playlist.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" - "); // Splitting title and artist

                if (parts.length == 2) {
                    System.out.println("Song: " + parts[0] + " | Artist: " + parts[1]);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Playlist file not found.");
        }
    }
}
