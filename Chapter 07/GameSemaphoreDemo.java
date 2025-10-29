import java.util.concurrent.Semaphore;

public class GameSemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2); // Limit to 2 concurrent logins

        for (int i = 1; i <= 5; i++) {
            new Thread(new GameLoginTask(semaphore), "Player " + i).start();
        }
    }
}