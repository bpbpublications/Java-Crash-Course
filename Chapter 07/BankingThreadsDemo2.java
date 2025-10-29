public class BankingThreadsDemo2 {
    public static void main(String[] args) {
        Thread transaction1 = new Thread(new TransactionProcessor("TXN001"));
        Thread transaction2 = new Thread(new TransactionProcessor("TXN002"));

        transaction1.start(); // Start the first transaction thread
        transaction2.start(); // Start the second transaction thread
    }
}