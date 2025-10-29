import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class AudioStream {
    public static void main(String[] args) {
        String fileName = "audio.mp3";

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName))) {
            byte[] buffer = new byte[4096]; // 4KB buffer
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                System.out.println("Streaming " + bytesRead + " bytes...");
            }
        } catch (IOException e) {
            System.err.println("Error streaming audio: " + e.getMessage());
        }
    }
}
