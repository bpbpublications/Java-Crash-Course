import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionHierarchyExample {
    public static void main(String[] args) {
        try {
            // Checked Exception: Must handle or declare
            readFromFile("this_file_does_not_exist.txt");

            // Unchecked Exception: No requirement to handle
            int result = divide(10, 0);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Math error: " + e.getMessage());
        } finally {
            System.out.println("Cleanup actions can go here.");
        }
    }

    public static void readFromFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file); // Throws FileNotFoundException
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }

    public static int divide(int a, int b) {
        return a / b; // Throws ArithmeticException for b = 0
    }
}
