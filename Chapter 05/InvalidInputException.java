/*
 * This class is a 
 * custom checked 
 * exception example 
 */
public class InvalidInputException extends Exception {
    private int errorCode;

    // Default Constructor
    public InvalidInputException() {
        super("Invalid input provided.");
    }

    // Constructor with Custom Message
    public InvalidInputException(String message) {
        super(message);
    }

    // Constructor with Custom Message and Error Code
    public InvalidInputException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    // Getter for Error Code
    public int getErrorCode() {
        return errorCode;
    }
}
