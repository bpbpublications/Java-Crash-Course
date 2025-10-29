import java.util.concurrent.CyclicBarrier;

class GamePlayer implements Runnable {
    private final CyclicBarrier barrier;
    private final String name;

    public GamePlayer(CyclicBarrier barrier, String name) {
        this.barrier = barrier;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " is ready.");
            barrier.await(); // Wait for all players to be ready
            System.out.println(name + " starts playing!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}