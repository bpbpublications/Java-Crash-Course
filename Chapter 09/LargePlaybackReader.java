import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class LargePlaybackReader {
    public static void main(String[] args) {
        String fileName = "playback_log.txt";

        try (FileInputStream fis = new FileInputStream(fileName);
             BufferedInputStream bis = new BufferedInputStream(fis)) {

            int data;
            while ((data = bis.read()) != -1) {
                System.out.print((char) data);
            }

        } catch (IOException e) {
            System.err.println("Error reading log: " + e.getMessage());
        }
    }
}
