import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class MediaMetadataReader {
    public static void main(String[] args) {
        String fileName = "media_metadata.dat";

        try (FileInputStream fis = new FileInputStream(fileName);
             DataInputStream dis = new DataInputStream(fis)) {

            // Reading song metadata
            String title = dis.readUTF();
            double duration = dis.readDouble();
            int popularity = dis.readInt();

            System.out.println("Media Metadata:");
            System.out.println("Title: " + title);
            System.out.println("Duration: " + duration + " mins");
            System.out.println("Play Count: " + popularity);

        } catch (IOException e) {
            System.err.println("Error reading metadata: " + e.getMessage());
        }
    }
}
