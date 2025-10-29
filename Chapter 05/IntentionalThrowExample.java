public class IntentionalThrowExample {
    public static void main(String[] args) {
        try {
            validateAge(119); // Will throw an exception
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    public static void validateAge(int age) {
        if (age > 99) {
            throw new IllegalArgumentException("Maximum age allowed is 99.");
        }
    }
}
