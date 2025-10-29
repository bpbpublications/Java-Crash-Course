import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameExecutorDemo1 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(new GameRenderTask());
        executor.execute(new GameInputTask());
        executor.execute(new GameSpawnNPCTask());

        executor.shutdown();
    }
}
