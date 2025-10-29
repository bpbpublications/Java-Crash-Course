import java.nio.file.*;

public class FileCheckExampmle {
    public static void main(String[] args) {
        Path path = Paths.get("playlist.txt");

        if (Files.exists(path)) {
            System.out.println("File exists: " + path.toAbsolutePath());
        } else {
            System.out.println("File not found.");
        }
    }
}
