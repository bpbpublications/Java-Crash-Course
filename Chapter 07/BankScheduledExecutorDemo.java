import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BankScheduledExecutorDemo {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Schedule the task to run every 10 seconds
        scheduler.scheduleAtFixedRate(new BankBalanceNotifications(), 0, 10, TimeUnit.SECONDS);
    }
}