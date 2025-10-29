import java.util.Scanner;

public class MixingInputMethodsFixed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Fixed: Consume leftover newline
        
        System.out.print("Enter your favorite song: ");
        String song = scanner.nextLine();
        

        System.out.println("Age: " + age + ", Favorite Song: " + song);
        scanner.close();
    }
}