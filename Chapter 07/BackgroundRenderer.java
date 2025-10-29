class BackgroundRenderer extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 24; i++) {
            System.out.println("Rendering background frame " + i);
            try {
                Thread.sleep(300); // Simulate rendering time
            } catch (InterruptedException e) {
                System.out.println("Rendering interrupted");
            }
        }
    }
}


