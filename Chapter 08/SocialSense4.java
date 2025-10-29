import java.util.*;

class UserActivity4 {
    private String username;
    private int posts;

    public UserActivity4(String username, int posts) {
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

public class SocialSense4 {
    public static void main(String[] args) {
        List<UserActivity4> activities = List.of(
            new UserActivity4("Neo", 319),
            new UserActivity4("Trinity", 3),
            new UserActivity4("Morpheus", 7),
            new UserActivity4("AgentSmith", 24),
            new UserActivity4("Cypher", 1),
            new UserActivity4("Oracle", 999)
        );

        // Example 1: Retrieving the most active user
        Optional<UserActivity4> mostActiveUser = activities.stream()
            .max(Comparator.comparingInt(UserActivity4::getPosts));

        mostActiveUser.ifPresent(user -> System.out.println(
            "Most Active User: " + user.getUsername() + " with " + user.getPosts() + " posts"));

        // Example 2: Providing a default value if no active user is found
        String message = activities.stream()
            .filter(activity -> activity.getPosts() >= 10)
            .findFirst()
            .map(UserActivity4::getUsername)
            .orElse("No active users found");

        System.out.println(message);

        // Example 3: Avoiding NullPointerException with Optional.ofNullable
        UserActivity4 potentialUser = getUserActivityById("Charlie", activities);
        Optional<UserActivity4> optionalUser = Optional.ofNullable(potentialUser);

        optionalUser.ifPresentOrElse(
            u -> System.out.println("User found: " + u.getUsername()),
            () -> System.out.println("User not found")
        );

        // Example 4: Using orElseThrow to handle missing values
        try {
            UserActivity4 user = activities.stream()
                .filter(activity -> activity.getUsername().equals("Eve"))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("User not found"));

            System.out.println("Found user: " + user.getUsername());
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    private static UserActivity4 getUserActivityById(String username, List<UserActivity4> activities) {
        return activities.stream()
            .filter(activity -> activity.getUsername().equals(username))
            .findFirst()
            .orElse(null);
    }
}
