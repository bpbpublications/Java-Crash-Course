import java.util.concurrent.CountDownLatch;

class GameResourceLoader implements Runnable {
    private final CountDownLatch latch;
    private final String resource;

    public GameResourceLoader(CountDownLatch latch, String resource) {
        this.latch = latch;
        this.resource = resource;
    }

    @Override
    public void run() {
        System.out.println("Loading " + resource);
        try {
            Thread.sleep(1000); // Simulate loading time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(resource + " loaded.");
        latch.countDown();
    }
}