import java.util.concurrent.CyclicBarrier;

public class GameCyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, () -> System.out.println("All players are ready. Game starts!"));

        new Thread(new GamePlayer(barrier, "Player 1")).start();
        new Thread(new GamePlayer(barrier, "Player 2")).start();
        new Thread(new GamePlayer(barrier, "Player 3")).start();
    }
}