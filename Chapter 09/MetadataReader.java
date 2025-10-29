import java.io.FileInputStream;
import java.io.IOException;

public class MetadataReader {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("metadata.dat")) {
            int data;
            while ((data = fis.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            System.err.println("Error reading metadata file: " + e.getMessage());
        }
    }
}
