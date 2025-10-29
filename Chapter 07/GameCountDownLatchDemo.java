import java.util.concurrent.CountDownLatch;

public class GameCountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        new Thread(new GameResourceLoader(latch, "Textures")).start();
        new Thread(new GameResourceLoader(latch, "Sounds")).start();
        new Thread(new GameResourceLoader(latch, "Models")).start();
        new Thread(new GameResourceLoader(latch, "Levels")).start();

        latch.await(); // Wait for all resources to load
        System.out.println("All resources loaded. Game starting...");
    }
}