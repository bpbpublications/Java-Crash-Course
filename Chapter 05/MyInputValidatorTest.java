public class MyInputValidatorTest {
    public static void main(String[] args) {
        MyInputValidator validator = new MyInputValidator();
        try {
            validator.validateTheAge(15);
            System.out.println("Test failed: No exception was thrown.");
        } catch (InvalidMathInputException e) {
            System.out.println("Test passed: Caught InvalidMathInputException.");
            System.out.println("Exception message: " + e.getMessage());
        }
    }
}