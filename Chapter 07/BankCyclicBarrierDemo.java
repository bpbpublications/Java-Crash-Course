import java.util.concurrent.CyclicBarrier;

public class BankCyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, () -> System.out.println("All departments have finished. Generating financial report."));

        new Thread(new BankDepartmentTask(barrier, "Finance")).start();
        new Thread(new BankDepartmentTask(barrier, "Risk")).start();
        new Thread(new BankDepartmentTask(barrier, "Compliance")).start();
    }
}