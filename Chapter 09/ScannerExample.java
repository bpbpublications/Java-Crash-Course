import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your favorite song: ");
        String song = scanner.nextLine();
        System.out.println("You entered: " + song);
        scanner.close();
    }
}
