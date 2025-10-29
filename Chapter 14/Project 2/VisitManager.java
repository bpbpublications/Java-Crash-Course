import java.sql.*;
import java.util.Scanner;

public class VisitManager {

    private static final String DB_URL = "jdbc:sqlite:pmrs.db";

    public static void showMenu(Scanner scanner) {
        boolean back = false;

        while (!back) {
            System.out.println("\n--- Manage Medical Visits ---");
            System.out.println("1. Add New Visit for a Pet");
            System.out.println("2. View All Visits");
            System.out.println("3. View Visits by Pet ID");
            System.out.println("4. Update Visit Details");
            System.out.println("5. Delete Visit Record");
            System.out.println("6. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = getUserChoice(scanner);
            switch (choice) {
                case 1 -> addVisit(scanner);
                case 2 -> viewAllVisits();
                case 3 -> viewVisitsByPetId(scanner);
                case 4 -> updateVisit(scanner);
                case 5 -> deleteVisit(scanner);
                case 6 -> back = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    private static int getUserChoice(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void addVisit(Scanner scanner) {
        System.out.print("Enter Pet ID: ");
        int petId = getUserChoice(scanner);
        scanner.nextLine(); // consume newline

        System.out.print("Enter visit date (YYYY-MM-DD): ");
        String visitDate = scanner.nextLine();

        System.out.print("Enter reason for visit: ");
        String reason = scanner.nextLine();

        System.out.print("Enter visit notes: ");
        String notes = scanner.nextLine();

        String sql = "INSERT INTO MedicalVisits(pet_id, visit_date, reason, notes) VALUES (?, ?, ?, ?)";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, petId);
            pstmt.setString(2, visitDate);
            pstmt.setString(3, reason);
            pstmt.setString(4, notes);
            pstmt.executeUpdate();
            System.out.println("Visit added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding visit: " + e.getMessage());
        }
    }

    private static void viewAllVisits() {
        String sql = "SELECT * FROM MedicalVisits";

        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- All Medical Visits ---");
            while (rs.next()) {
                System.out.printf("Visit ID: %d | Pet ID: %d | Date: %s | Reason: %s | Notes: %s%n",
                        rs.getInt("visit_id"),
                        rs.getInt("pet_id"),
                        rs.getString("visit_date"),
                        rs.getString("reason"),
                        rs.getString("notes"));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving visits: " + e.getMessage());
        }
    }

    private static void viewVisitsByPetId(Scanner scanner) {
        System.out.print("Enter Pet ID to search visits: ");
        int petId = getUserChoice(scanner);

        String sql = "SELECT * FROM MedicalVisits WHERE pet_id = ?";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, petId);
            ResultSet rs = pstmt.executeQuery();
            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.printf("Visit ID: %d | Date: %s | Reason: %s | Notes: %s%n",
                        rs.getInt("visit_id"),
                        rs.getString("visit_date"),
                        rs.getString("reason"),
                        rs.getString("notes"));
            }
            if (!found) {
                System.out.println("No visits found for this pet.");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving visits: " + e.getMessage());
        }
    }

    private static void updateVisit(Scanner scanner) {
        System.out.print("Enter the ID of the visit to update: ");
        int visitId = getUserChoice(scanner);
        scanner.nextLine(); // consume newline

        System.out.print("Enter new date (YYYY-MM-DD) or press Enter to skip: ");
        String date = scanner.nextLine();

        System.out.print("Enter new reason or press Enter to skip: ");
        String reason = scanner.nextLine();

        System.out.print("Enter new notes or press Enter to skip: ");
        String notes = scanner.nextLine();

        String sql = "UPDATE MedicalVisits SET "
                + "visit_date = COALESCE(NULLIF(?, ''), visit_date), "
                + "reason = COALESCE(NULLIF(?, ''), reason), "
                + "notes = COALESCE(NULLIF(?, ''), notes) "
                + "WHERE visit_id = ?";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, date);
            pstmt.setString(2, reason);
            pstmt.setString(3, notes);
            pstmt.setInt(4, visitId);
            int updated = pstmt.executeUpdate();
            if (updated > 0) {
                System.out.println("Visit updated successfully.");
            } else {
                System.out.println("Visit not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating visit: " + e.getMessage());
        }
    }

    private static void deleteVisit(Scanner scanner) {
        System.out.print("Enter the ID of the visit to delete: ");
        int visitId = getUserChoice(scanner);

        String sql = "DELETE FROM MedicalVisits WHERE visit_id = ?";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, visitId);
            int deleted = pstmt.executeUpdate();
            if (deleted > 0) {
                System.out.println("Visit deleted successfully.");
            } else {
                System.out.println("Visit not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting visit: " + e.getMessage());
        }
    }
}
