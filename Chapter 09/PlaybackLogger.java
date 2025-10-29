import java.io.*;
import java.util.List;
import java.util.ArrayList;

class PlaybackHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    private String songTitle;
    private String timestamp;

    public PlaybackHistory(String songTitle, String timestamp) {
        this.songTitle = songTitle;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Song: " + songTitle + " | Played at: " + timestamp;
    }
}

public class PlaybackLogger {
    private static final String FILE_NAME = "playback.dat";

    public static void main(String[] args) {
        PlaybackHistory newPlayback = new PlaybackHistory("Whispering Pines", "2025-01-30 14:45");

        List<PlaybackHistory> playbackList = readPlaybackHistory(); // Load previous records
        playbackList.add(newPlayback); // Append new record

        writePlaybackHistory(playbackList);
        System.out.println("Updated Playback History:");
        playbackList.forEach(System.out::println);
    }

    /**
     * Reads previous playback history from file.
     */
    private static List<PlaybackHistory> readPlaybackHistory() {
        try (FileInputStream fis = new FileInputStream(FILE_NAME);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            return (List<PlaybackHistory>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>(); // Return empty list if file not found
        }
    }

    /**
     * Writes updated playback history to file.
     */
    private static void writePlaybackHistory(List<PlaybackHistory> history) {
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(history);
            System.out.println("Playback history updated.");
        } catch (IOException e) {
            System.err.println("Error writing playback history: " + e.getMessage());
        }
    }
}
