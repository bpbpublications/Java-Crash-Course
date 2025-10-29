import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MetadataWriter {
    public static void main(String[] args) {
        List<MediaMetadata> mediaList = new ArrayList<>();
        mediaList.add(new MediaMetadata("Whispering Pines", "The Howling Wolves", "Folk", 4.35));
        mediaList.add(new MediaMetadata("Ocean Breeze", "The Soaring Eagles", "Instrumental", 5.12));
        mediaList.add(new MediaMetadata("Golden Meadow", "The Grazing Deer", "Acoustic", 3.48));

        try (FileOutputStream fos = new FileOutputStream("metadata.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            
            oos.writeObject(mediaList);
            System.out.println("Media metadata saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving metadata: " + e.getMessage());
        }
    }
}
