import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PlaylistReader {
    public static void main(String[] args) {
        try {
            File file = new File("playlist.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String song = scanner.nextLine();
                System.out.println("Now playing: " + song);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Playlist file not found.");
        }
    }
}
