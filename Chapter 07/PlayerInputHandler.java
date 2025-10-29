class PlayerInputHandler implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 24; i++) {
            System.out.println("Processing player input " + i);
            try {
                Thread.sleep(300); // Simulate input processing delay
            } catch (InterruptedException e) {
                System.out.println("Input processing interrupted");
            }
        }
    }
}