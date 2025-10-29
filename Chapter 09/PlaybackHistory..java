import java.io.Serializable;

class PlaybackHistory implements Serializable {
    private static final long serialVersionUID = 2L; // Updated version

    private String songTitle;
    private String timestamp;
    private transient String deviceUsed; // New field (not serialized)

    public PlaybackHistory(String songTitle, String timestamp, String deviceUsed) {
        this.songTitle = songTitle;
        this.timestamp = timestamp;
        this.deviceUsed = deviceUsed;
    }

    @Override
    public String toString() {
        return "Song: " + songTitle + " | Played at: " + timestamp + " | Device: " + (deviceUsed != null ? deviceUsed : "Unknown");
    }
}
