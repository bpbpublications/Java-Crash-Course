import java.util.*;
import java.util.stream.*;

class UserActivity2 {
    private String username;
    private int posts;
    private List<String> tags;

    public UserActivity2(String username, int posts, List<String> tags) {
        this.username = username;
        this.posts = posts;
        this.tags = tags;
    }

    public String getUsername() {
        return username;
    }

    public int getPosts() {
        return posts;
    }

    public List<String> getTags() {
        return tags;
    }
}

public class SocialSense2 {
    public static void main(String[] args) {
        List<UserActivity2> activities = List.of(
            new UserActivity2("Neo", 319, List.of("#theone", "#zion", "#coding")),
            new UserActivity2("Trinity", 3, List.of("#love", "#java", "#free")),
            new UserActivity2("Morpheus", 7, List.of("#ship", "#zion", "#fight")),
            new UserActivity2("AgentSmith", 24, List.of("#virus", "#merge", "#destroy")),
            new UserActivity2("Cypher", 1, List.of("#code", "#help", "#phone")),
            new UserActivity2("Oracle", 999, List.of("#spirit", "#architect", "#coding"))
        );

        // Example: Active User Analysis
        System.out.println("\nOutput from \"Example: Active User Analysis\"");
        List<String> activeUsers = activities.stream()
            .filter(activity -> activity.getPosts() >= 10) // Retain active users
            .map(UserActivity2::getUsername) // Extract usernames
            .sorted() // Sort alphabetically
            .collect(Collectors.toList()); // Collect into a list

        System.out.println("Active Users: " + activeUsers);

        // Example: Tag Analytics with flatMap
        System.out.println("\nOutput from \"Example: Tag Analyticss with flatMap\"");
        List<String> uniqueTags = activities.stream()
            .flatMap(activity -> activity.getTags().stream()) // Flatten all hashtags into a single stream
            .distinct() // Remove duplicates
            .sorted() // Sort alphabetically
            .collect(Collectors.toList()); // Collect into a list

        System.out.println("Unique Tags: " + uniqueTags);

        // Example: Most Active User
        System.out.println("\nOutput from \"Example: Most Active User\"");
        activities.stream()
            .max(Comparator.comparingInt(UserActivity2::getPosts)) // Find user with the max posts
            .ifPresent(user -> System.out.println("Most Active User: " + user.getUsername() +
                " with " + user.getPosts() + " posts"));

        // Example: Aggregating Post Statistics
        System.out.println("\nOutput from \"Example: Aggregating Post Statistics\"");
        int totalPosts = activities.stream()
            .mapToInt(UserActivity2::getPosts) // Convert UserActivity to an IntStream of post counts
            .sum(); // Sum all post counts

        double averagePosts = activities.stream()
            .mapToInt(UserActivity2::getPosts)
            .average() // Calculate the average
            .orElse(0.0); // Provide a default value if no elements are present

        System.out.println("Total Posts: " + totalPosts);
        System.out.println("Average Posts per User: " + averagePosts);

        // Example: Generating a Report
        System.out.println("\nOutput from \"Example: Generating a Report\"");
        activities.stream()
            .filter(activity -> activity.getPosts() >= 10) // Retain active users
            .sorted(Comparator.comparingInt(UserActivity2::getPosts).reversed()) // Sort by posts, descending
            .map(activity -> activity.getUsername() + " - " + activity.getPosts() + " posts") // Format output
            .forEach(System.out::println); // Print each line
    }
}
