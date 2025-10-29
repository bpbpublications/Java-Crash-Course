public class BankingLocksDemo1 {
    public static void main(String[] args) {
        BankAccount1 account = new BankAccount1(1500);

        Thread user1 = new Thread(() -> account.withdraw(900));
        Thread user2 = new Thread(() -> account.withdraw(700));

        user1.start();
        user2.start();
    }
}