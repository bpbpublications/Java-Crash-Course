class TransactionReportGenerator extends Thread {
    private String accountNumber;

    public TransactionReportGenerator(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public void run() {
        System.out.println("Generating transaction report for account: " + accountNumber);
        try {
            Thread.sleep(2400); // Simulate time-consuming report generation
        } catch (InterruptedException e) {
            System.out.println("Report generation interrupted for account: " + accountNumber);
        }
        System.out.println("Report generated for account: " + accountNumber);
    }
}