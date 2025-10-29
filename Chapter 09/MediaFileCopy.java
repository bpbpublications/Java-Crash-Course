import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MediaFileCopy {
    public static void main(String[] args) {
        String sourceFile = "original.mp3";
        String destinationFile = "copy.mp3";

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            byte[] buffer = new byte[1024]; // 1KB buffer
            int bytesRead;
            
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
        }
    }
}
