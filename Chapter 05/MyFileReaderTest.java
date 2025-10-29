import java.io.FileNotFoundException;

public class MyFileReaderTest {
    public static void main(String[] args) {
        MyFileReader fileReader = new MyFileReader();
        try {
            fileReader.readMyFile("nonexistentfile.txt");
            System.out.println("Test failed: No exception was thrown.");
        } catch (FileNotFoundException e) {
            System.out.println("Test passed: Caught FileNotFoundException.");
            System.out.println("Exception message: " + e.getMessage());
        }
    }
}
