import java.io.FileWriter;
import java.io.IOException;

public class PlaylistWriter {
    public static void main(String[] args) {
        String fileName = "playlist.txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Whispering Pines - The Howling Wolves\n");
            writer.write("Ocean Breeze - The Soaring Eagles\n");
            System.out.println("Playlist saved.");
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}
