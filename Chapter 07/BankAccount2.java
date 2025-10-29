import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount2 {
    private double balance;
    private final Lock lock = new ReentrantLock();

    public BankAccount2(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount) {
        if (lock.tryLock()) {
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
            System.out.println("Unable to acquire lock. Transaction skipped.");
        }
    }
}