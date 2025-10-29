public class MyCustomExceptionTest {
    public static void main(String[] args) {
        try {
            throw new MyCustomException("Custom error occurred.", 404);
        } catch (MyCustomException e) {
            System.out.println("Test passed: Caught MyCustomException.");
            System.out.println("Message: " + e.getMessage());
            System.out.println("Error Code: " + e.getErrorCode());
        }
    }
}