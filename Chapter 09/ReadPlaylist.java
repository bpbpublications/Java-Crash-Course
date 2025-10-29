import java.nio.file.*;
import java.io.IOException;
import java.util.List;

public class ReadPlaylist {
    public static void main(String[] args) {
        Path filePath = Paths.get("playlist.txt");

        try {
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                System.out.println("Now playing: " + line);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
