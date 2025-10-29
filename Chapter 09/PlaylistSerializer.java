import java.io.*;
import java.util.ArrayList;
import java.util.List;

class PlaylistEntry implements Serializable {
    private static final long serialVersionUID = 1L;
    private String title;
    private String artist;

    public PlaylistEntry(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Song: " + title + " | Artist: " + artist;
    }
}

public class PlaylistSerializer {
    private static final String FILE_NAME = "playlist.dat";

    public static void main(String[] args) {
        List<PlaylistEntry> playlist = new ArrayList<>();
        playlist.add(new PlaylistEntry("Golden Meadow", "The Grazing Deer"));
        playlist.add(new PlaylistEntry("Ocean Breeze", "The Soaring Eagles"));

        writePlaylist(playlist);
        System.out.println("Playlist saved successfully.");

        List<PlaylistEntry> loadedPlaylist = readPlaylist();
        System.out.println("\nLoaded Playlist:");
        loadedPlaylist.forEach(System.out::println);
    }

    /**
     * Writes the playlist to a file using buffering.
     */
    private static void writePlaylist(List<PlaylistEntry> playlist) {
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {

            oos.writeObject(playlist);
        } catch (IOException e) {
            System.err.println("Error writing playlist: " + e.getMessage());
        }
    }

    /**
     * Reads the playlist from the file.
     */
    private static List<PlaylistEntry> readPlaylist() {
        try (FileInputStream fis = new FileInputStream(FILE_NAME);
             BufferedInputStream bis = new BufferedInputStream(fis);
             ObjectInputStream ois = new ObjectInputStream(bis)) {

            return (List<PlaylistEntry>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>(); // Return empty list if file is missing
        }
    }
}
