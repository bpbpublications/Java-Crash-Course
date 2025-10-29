import java.util.concurrent.CountDownLatch;

class BankApprovalTask implements Runnable {
    private final CountDownLatch latch;
    private final String department;

    public BankApprovalTask(CountDownLatch latch, String department) {
        this.latch = latch;
        this.department = department;
    }

    @Override
    public void run() {
        System.out.println("Approval from " + department + " in progress...");
        try {
            Thread.sleep(1500); // Simulate approval time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(department + " approved.");
        latch.countDown();
    }
}