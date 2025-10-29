import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class LargePlaybackLogger {
    public static void main(String[] args) {
        String logEntry = "User played: Symphony of the Stars - Aurora Sounds\n";
        String fileName = "playback_log.txt";

        try (FileOutputStream fos = new FileOutputStream(fileName, true);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {

            bos.write(logEntry.getBytes(StandardCharsets.UTF_8));
            bos.flush(); // Ensures data is written immediately
            System.out.println("Playback log updated.");

        } catch (IOException e) {
            System.err.println("Error writing log: " + e.getMessage());
        }
    }
}
