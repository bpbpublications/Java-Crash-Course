public class RelationalOperatorExample {
    public static void main(String[] args) {
        int nbrA = 24;
        int nbrB = 319;

        // Equal to (==)
        if (nbrA == nbrB) {
            System.out.println("A is equal to B.");
        } else {
            System.out.println("A is not equal to B.");
        }

        // Not equal to (!=)
        if (nbrA != nbrB) {
            System.out.println("A is not equal to B.");
        } else {
            System.out.println("A is equal to B.");
        }

        // Greater than (>)
        if (nbrA > nbrB) {
            System.out.println("A is greater than B.");
        } else {
            System.out.println("A is not greater than B.");
        }

        // Less than (<)
        if (nbrA < nbrB) {
            System.out.println("A is less than B.");
        } else {
            System.out.println("A is not less than B.");
        }

        // Greater than or equal to (>=)
        if (nbrA >= nbrB) {
            System.out.println("A is greater than or equal to B.");
        } else {
            System.out.println("A is not greater than or equal to B.");
        }

        // Less than or equal to (<=)
        if (nbrA <= nbrB) {
            System.out.println("A is less than or equal to B.");
        } else {
            System.out.println("A is not less than or equal to B.");
        }
    }
}
