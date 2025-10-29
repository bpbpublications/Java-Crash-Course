import java.util.*;
import java.util.stream.*;

class UserActivity3 {
    private String username;
    private int posts;

    public UserActivity3(String username, int posts) {
        this.username = username;
        this.posts = posts;
    }

    public String getUsername() {
        return username;
    }

    public int getPosts() {
        return posts;
    }

    @Override
    public String toString() {
        return username + " - " + posts + " posts";
    }
}

public class SocialSense3 {
    public static void main(String[] args) {
        List<UserActivity3> activities = List.of(
            new UserActivity3("Neo", 319),
            new UserActivity3("Trinity", 3),
            new UserActivity3("Morpheus", 7),
            new UserActivity3("AgentSmith", 24),
            new UserActivity3("Cypher", 1),
            new UserActivity3("Oracle", 999)
        );

        // Filtering active users (5 or more posts)
        List<UserActivity3> activeUsers = activities.stream()
            .filter(activity -> activity.getPosts() >= 10)
            .collect(Collectors.toList());

        System.out.println("Active Users:");
        activeUsers.forEach(System.out::println);

        // Extracting and printing usernames
        List<String> usernames = activities.stream()
            .map(UserActivity3::getUsername)
            .collect(Collectors.toList());

        System.out.println("\nUsernames:");
        usernames.forEach(System.out::println);

        // Sorting users by post count (descending)
        List<UserActivity3> sortedUsers = activities.stream()
            .sorted((a, b) -> Integer.compare(b.getPosts(), a.getPosts()))
            .collect(Collectors.toList());

        System.out.println("\nSorted Users:");
        sortedUsers.forEach(System.out::println);

        // Generating and displaying user report
        System.out.println("\nUser Report:");
        activities.stream()
            .filter(activity -> activity.getPosts() >= 10)
            .sorted((a, b) -> Integer.compare(b.getPosts(), a.getPosts()))
            .map(activity -> activity.getUsername() + " - " + activity.getPosts() + " posts")
            .forEach(System.out::println);
    }
}
