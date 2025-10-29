import java.util.concurrent.CyclicBarrier;

class BankDepartmentTask implements Runnable {
    private final CyclicBarrier barrier;
    private final String department;

    public BankDepartmentTask(CyclicBarrier barrier, String department) {
        this.barrier = barrier;
        this.department = department;
    }

    @Override
    public void run() {
        try {
            System.out.println(department + " department is preparing data.");
            Thread.sleep(2000); // Simulate data preparation time
            System.out.println(department + " department has finished.");
            barrier.await(); // Wait for other departments
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}