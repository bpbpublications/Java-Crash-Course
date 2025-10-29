public class BankingThreadsDemo3 {
    public static void main(String[] args) {
        Thread reportThread = new TransactionReportGenerator("12345");
        Thread transactionThread = new Thread(new TransactionProcessor("TXN001"));

        reportThread.start();
        transactionThread.start();

        System.out.println("Banking system is handling tasks concurrently.");
    }
}