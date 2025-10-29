import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount1 {
    private double balance;
    private final Lock lock = new ReentrantLock();

    public BankAccount1(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount) {
        lock.lock(); // Obtain lock
        try {
            if (balance >= amount) {
                System.out.println("Withdrawing: " + amount);
                balance -= amount;
                System.out.println("Remaining Balance: " + balance);
            } else {
                System.out.println("Low funds; cannot withdraw: " + amount);
            }
        } finally {
            lock.unlock(); // Release lock
        }
    }
}
