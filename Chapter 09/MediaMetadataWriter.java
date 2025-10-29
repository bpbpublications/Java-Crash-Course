import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MediaMetadataWriter {
    public static void main(String[] args) {
        String fileName = "media_metadata.dat";

        try (FileOutputStream fos = new FileOutputStream(fileName);
             DataOutputStream dos = new DataOutputStream(fos)) {

            // Writing song metadata
            dos.writeUTF("Symphony of the Stars");  // Song Title
            dos.writeDouble(4.35);                 // Duration in minutes
            dos.writeInt(50000);                   // Popularity (play count)

            System.out.println("Media metadata saved successfully.");

        } catch (IOException e) {
            System.err.println("Error writing metadata: " + e.getMessage());
        }
    }
}
