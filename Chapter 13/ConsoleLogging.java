import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsoleLogging {
    // Create a logger instance
    private static final Logger logger = Logger.getLogger(ConsoleLogging.class.getName());

    public static void main(String[] args) {
        logger.info("Application started.");

        int number1 = 10;
        int number2 = 5;
        
        logger.fine("Variables initialized: number1=" + number1 + ", number2=" + number2);

        try {
            int result = divideNumbers(number1, number2);
            logger.info("Result of division: " + result);
        } catch (ArithmeticException e) {
            logger.log(Level.SEVERE, "An error occurred during division: ", e);
        }

        logger.info("Application finished.");
    }

    private static int divideNumbers(int num1, int num2) {
        logger.fine("Dividing numbers: " + num1 + " / " + num2);
        if (num2 == 0) {
            throw new ArithmeticException("Division by zero!");
        }
        return num1 / num2;
    }
}