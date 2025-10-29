import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LyricsReader {
    public static void main(String[] args) {
        String fileName = "song_lyrics.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading lyrics: " + e.getMessage());
        }
    }
}
