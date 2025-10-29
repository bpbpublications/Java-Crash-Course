public class GameSynchronizationDemo1 {
    public static void main(String[] args) {
        GameHealthBar healthBar = new GameHealthBar();

        Thread damageThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                healthBar.takeDamage(10);
                try {
                    Thread.sleep(50); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread healThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                healthBar.heal(5);
                try {
                    Thread.sleep(70); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        damageThread.start();
        healThread.start();
    }
}