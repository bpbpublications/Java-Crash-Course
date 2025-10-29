class TransactionProcessor implements Runnable {
    private String transactionId;

    public TransactionProcessor(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public void run() {
        System.out.println("Processing transaction: " + transactionId);
        try {
            Thread.sleep(2400); // Simulate transaction processing delay
        } catch (InterruptedException e) {
            System.out.println("Transaction interrupted: " + transactionId);
        }
        System.out.println("Transaction completed: " + transactionId);
    }
}