public class BankingThreadsDemo1 {
    public static void main(String[] args) {
        TransactionReportGenerator report1 = new TransactionReportGenerator("12345");
        TransactionReportGenerator report2 = new TransactionReportGenerator("67890");

        report1.start(); // Start the first report thread
        report2.start(); // Start the second report thread
    }
}