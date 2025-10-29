public class MyInputValidator {
    public void validateTheAge(int age) throws InvalidMathInputException {
        if (age < 21) {
            throw new InvalidMathInputException("Minimum age allowed is 21.");
        }
    }
}