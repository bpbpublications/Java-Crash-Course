import java.util.concurrent.Semaphore;

class GameLoginTask implements Runnable {
    private final Semaphore semaphore;

    public GameLoginTask(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " logged in.");
            Thread.sleep(2000); // Simulate gameplay
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " logged out.");
            semaphore.release();
        }
    }
}