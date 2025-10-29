import java.util.Random;

public class RandomExample {
    public static void main(String[] args) {
        // Create an instance of Random
        Random random = new Random();

        // Generate random numbers
        int randomInt1 = random.nextInt(10); // Random integer between 0 and 9
        int randomInt2 = random.nextInt(100); // Random integer between 0 and 99
        int randomInt3 = random.nextInt(1000); // Random integer between 0 and 999
        double randomDouble = random.nextDouble(); // Random double between 0.0 and 1.0

        System.out.println("Random Integer (0 - 9): " + randomInt1);
        System.out.println("Random Integer (0 - 99): " + randomInt2);
        System.out.println("Random Integer (0 - 999): " + randomInt3);
        System.out.println("Random Double (0.0 - 1.0): " + randomDouble);
    }
}
