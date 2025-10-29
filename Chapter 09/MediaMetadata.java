import java.io.Serializable;

public class MediaMetadata implements Serializable {
    private static final long serialVersionUID = 1L; // Ensures compatibility during deserialization
    
    private String title;
    private String artist;
    private String genre;
    private double duration; // In minutes

    public MediaMetadata(String title, String artist, String genre, double duration) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nArtist: " + artist + "\nGenre: " + genre + "\nDuration: " + duration + " mins\n";
    }
}
