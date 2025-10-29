public class BankTransactionTask implements Runnable {
    private String transactionId;

    public BankTransactionTask(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public void run() {
        System.out.println("Processing transaction: " + transactionId);
    }
}