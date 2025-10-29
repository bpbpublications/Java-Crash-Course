public class BankingLocksDemo3 {
    public static void main(String[] args) {
        BankAccount3 account = new BankAccount3(1500);

        Thread user1 = new Thread(() -> account.withdraw(900));
        Thread user2 = new Thread(() -> account.withdraw(700));

        user1.start();
        user2.start();
    }
}