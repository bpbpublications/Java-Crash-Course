public class Ternary {
    public static void main(String[] args) {
        int nbrA = 8;
        int nbrB = 24;

        // Ternary operator to find the larger of two numbers
        int largest = (nbrA > nbrB) ? nbrA : nbrB;

        System.out.println("The largest value is: " + largest);

        // Another example: Ternary operator to determine if a number is even or odd
        String result = (nbrA % 2 == 0) ? "Even" : "Odd";
        System.out.println("nbrA is: " + result);
    }
}
