public class CustomExceptionImplementation {
    public static void main(String[] args) {
        try {
            processInput(-5);
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Error Code: " + e.getErrorCode());
        }
    }

    public static void processInput(int input) throws InvalidInputException {
        if (input <= 0) {
            throw new InvalidInputException("Input must be positive.", 1001);
        }
        System.out.println("Valid input: " + input);
    }
}
