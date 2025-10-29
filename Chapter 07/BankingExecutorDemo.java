import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankingExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        executor.execute(new BankTransactionTask("BTXN000001"));
        executor.execute(new BankTransactionTask("BTXN000002"));
        executor.execute(new BankTransactionTask("BTXN000003"));
        executor.execute(new BankTransactionTask("BTXN000004"));
        executor.execute(new BankTransactionTask("BTXN000005"));

        executor.shutdown();
    }
}