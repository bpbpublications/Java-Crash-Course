public class GameThreadsDemo3 {
    public static void main(String[] args) {
        Thread renderer = new BackgroundRenderer();
        Thread inputThread = new Thread(new PlayerInputHandler());

        renderer.start();
        inputThread.start();
    }
}