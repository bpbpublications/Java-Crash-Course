import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardOpenOption;

public class AppendPlaylist {
    public static void main(String[] args) {
        Path filePath = Paths.get("myPlaylist.txt");
        
        // Display current playlist
        System.out.println("Current Playlist:");
        displayPlaylist(filePath);

        // Get user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the song title: ");
        String songTitle = scanner.nextLine();
        System.out.print("Enter the artist name: ");
        String artist = scanner.nextLine();
        scanner.close();

        // Append new song to file
        String newEntry = songTitle + " - " + artist;
        appendToPlaylist(filePath, newEntry);

        // Display updated playlist
        System.out.println("\nUpdated Playlist:");
        displayPlaylist(filePath);
    }

    /**
     * Reads and displays the contents of the playlist file.
     */
    private static void displayPlaylist(Path filePath) {
        try {
            if (Files.exists(filePath)) {
                List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
                if (lines.isEmpty()) {
                    System.out.println("Playlist is empty.");
                } else {
                    lines.forEach(System.out::println);
                }
            } else {
                System.out.println("Playlist file not found. Creating a new one...");
                Files.createFile(filePath);
            }
        } catch (IOException e) {
            System.err.println("Error reading the playlist: " + e.getMessage());
        }
    }

    /**
     * Appends a new song entry to the playlist file.
     */
    private static void appendToPlaylist(Path filePath, String newEntry) {
        try {
            Files.write(filePath, Arrays.asList(newEntry), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            System.out.println("Song added successfully.");
        } catch (IOException e) {
            System.err.println("Error updating the playlist: " + e.getMessage());
        }
    }
}