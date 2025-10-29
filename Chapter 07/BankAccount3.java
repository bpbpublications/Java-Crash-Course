import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount3 {
    private double balance;
    private final Lock lock = new ReentrantLock();

    public BankAccount3(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount) {
        try {
            if (lock.tryLock(3, TimeUnit.SECONDS)) {
                try {
                    if (balance >= amount) {
                        System.out.println("Withdrawing: " + amount);
                        balance -= amount;
                        System.out.println("Remaining Balance: " + balance);
                    } else {
                        System.out.println("Low funds; cannot withdraw: " + amount);
                    }
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Unable to acquire lock within the timeout. Transaction skipped.");
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted while waiting for lock.");
        }
    }
}