import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryCatchFinallyExample {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            File file = new File("unlikelyfile.txt");
            scanner = new Scanner(file); // Might throw FileNotFoundException
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: The designated file was not found.");
        } finally {
            if (scanner != null) {
                scanner.close(); // Ensures resource is released
            }
            System.out.println("Finished file operations.");
        }
    }
}
