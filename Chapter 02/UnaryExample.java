public class UnaryExample {
    public static void main(String[] args) {
        int nbrA = 5;
        int nbrB = -10;
        boolean boolC = true;

        // Unary plus (+)
        int positiveA = +nbrA;  // No change in value
        System.out.println("Unary plus of nbrA: " + positiveA);  // Output: 5

        // Unary minus (-)
        int negativeB = -nbrB;  // Negates the value of nbrB
        System.out.println("Unary minus of nbrB: " + negativeB);  // Output: 10

        // Increment operator (++)
        nbrA++;  // nbrA = nbrA + 1
        System.out.println("After incrementing, nbrA: " + nbrA);  // Output: 6

        // Decrement operator (--)
        nbrB--;  // nbrB = nbrB - 1
        System.out.println("After decrementing, nbrB: " + nbrB);  // Output: -11

        // Logical complement (!)
        boolean notC = !boolC;  // Negates the boolean value of boolC
        System.out.println("Logical complement of boolC: " + notC);  // Output: false
    }
}
