public class MultipleRelationals {
    public static void main(String[] args) {
        int nbrA = 15;
        int nbrB = 10;
        int nbrC = 20;

        // Using multiple relational operators in a single line
        if (nbrA > nbrB && nbrA < nbrC) {
            System.out.println("A is greater than B AND less than C.");
        } else {
            System.out.println("A does not satisfy both conditions.");
        }
    }
}
