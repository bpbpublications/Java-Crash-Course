import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLExceptionExample {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Trying to connect to the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "user", "password");
            // Database operations would go here
        } catch (SQLException e) {
            // Handle the SQLException
            System.out.println("Database access error:");
            e.printStackTrace();
        } finally {
            // Close the connection (if it was established)
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error closing the connection:");
                    e.printStackTrace();
                }
            }
        }
    }
}
