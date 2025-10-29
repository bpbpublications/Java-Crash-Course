import java.util.Scanner;

public class MixingInputMethodsPitfall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = scanner.nextInt(); // Reads number but leaves \n in buffer

        System.out.print("Enter your favorite song: ");
        String song = scanner.nextLine(); // Skips input!

        System.out.println("Age: " + age + ", Favorite Song: " + song);
        scanner.close();
    }
}
