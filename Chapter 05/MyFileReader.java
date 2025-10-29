import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyFileReader {
    public String readMyFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        return scanner.nextLine();
    }
}
