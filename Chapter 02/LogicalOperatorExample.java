public class LogicalOperatorExample {
    public static void main(String[] args) {
        boolean isRainy = true;
        boolean isWeekend = false;
        boolean isHoliday = true;

        // Logical AND (&&) - Both conditions must be true
        if (isRainy && isWeekend) {
            System.out.println("It is a rainny weekend!");
        } else {
            System.out.println("It is not both rainy and a weekend.");
        }

        // Logical OR (||) - At least one condition must be true
        if (isWeekend || isHoliday) {
            System.out.println("Relaxation time, it is either a weekend or holiday.");
        } else {
            System.out.println("It is neither a weekend nor a holiday.");
        }

        // Logical NOT (!) - Negates the condition
        if (!isRainy) {
            System.out.println("It is not rainy today.");
        } else {
            System.out.println("It is rainy today.");
        }
    }
    
}
