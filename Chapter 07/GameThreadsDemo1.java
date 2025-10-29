public class GameThreadsDemo1 {
    public static void main(String[] args) {
        BackgroundRenderer renderer = new BackgroundRenderer();
        renderer.start(); // Start the background rendering thread
    }
}