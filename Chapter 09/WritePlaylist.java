import java.nio.file.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class WritePlaylist {
    public static void main(String[] args) {
        List<String> playlist = Arrays.asList(
            "Whispering Pines - The Howling Wolves",
            "Ocean Breeze - The Soaring Eagles",
            "Golden Meadow - The Grazing Deer"
        );

        Path filePath = Paths.get("newPlaylist.txt");

        try {
            Files.write(filePath, playlist);
            System.out.println("Nw playlist saved successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
