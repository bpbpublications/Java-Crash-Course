import java.util.*;

class UserActivity {
    private String username;
    private int posts;

    public UserActivity(String username, int posts) {
        this.username = username;
        this.posts = posts;
    }

    public String getUsername() {
        return username;
    }

    public int getPosts() {
        return posts;
    }
}

public class SocialSense1 {
    public static void main(String[] args) {
        List<UserActivity> activities = List.of(
            new UserActivity("Neo", 319),
            new UserActivity("Trinity", 3),
            new UserActivity("Morpheus", 7),
            new UserActivity("AgentSmith", 24),
            new UserActivity("Cypher", 1),
            new UserActivity("Oracle", 999)
        );

        long activeUsers = activities.stream()
            .filter(activity -> activity.getPosts() >= 10)
            .count();

        System.out.println("Active users: " + activeUsers);
    }
}
