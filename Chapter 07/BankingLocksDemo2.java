public class BankingLocksDemo2 {
    public static void main(String[] args) {
        BankAccount2 account = new BankAccount2(1500);

        Thread user1 = new Thread(() -> account.withdraw(900));
        Thread user2 = new Thread(() -> account.withdraw(700));

        user1.start();
        user2.start();
    }
}