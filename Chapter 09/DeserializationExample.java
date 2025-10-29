import java.io.*;
import java.util.List;

public class DeserializationExample {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("metadata.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            
            List<MediaMetadata> mediaList = (List<MediaMetadata>) ois.readObject();
            
            System.out.println("Retrieved Media Metadata:");
            for (MediaMetadata media : mediaList) {
                System.out.println(media);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading metadata: " + e.getMessage());
        }
    }
}
