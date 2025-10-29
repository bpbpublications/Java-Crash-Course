import java.util.concurrent.CountDownLatch;

public class BankCountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        new Thread(new BankApprovalTask(latch, "Finance")).start();
        new Thread(new BankApprovalTask(latch, "Risk Management")).start();
        new Thread(new BankApprovalTask(latch, "Compliance")).start();

        latch.await(); // Wait for all approvals
        System.out.println("Transaction approved by all departments.");
    }
}