import java.util.Calendar;

public class CalendarExample {
    public static void main(String[] args) {
        // Create a calendar instance and set a specific date
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.MARCH, 9);

        System.out.println("Custom Date: " + calendar.getTime());
    }
}
