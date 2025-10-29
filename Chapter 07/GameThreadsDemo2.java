public class GameThreadsDemo2 {
    public static void main(String[] args) {
        Thread inputThread = new Thread(new PlayerInputHandler());
        inputThread.start(); // Start the input handling thread
    }
}