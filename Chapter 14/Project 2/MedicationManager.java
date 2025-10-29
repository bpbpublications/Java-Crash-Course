import java.sql.*;
import java.util.Scanner;

public class MedicationManager {

    private static final String DB_URL = "jdbc:sqlite:pmrs.db";

    public static void showMenu(Scanner scanner) {
        boolean back = false;

        while (!back) {
            System.out.println("\n--- Manage Medications ---");
            System.out.println("1. Add Medication for a Visit");
            System.out.println("2. View All Medications");
            System.out.println("3. View Medications by Visit ID");
            System.out.println("4. Update Medication Details");
            System.out.println("5. Delete Medication Record");
            System.out.println("6. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = getUserChoice(scanner);
            switch (choice) {
                case 1 -> addMedication(scanner);
                case 2 -> viewAllMedications();
                case 3 -> viewMedicationsByVisit(scanner);
                case 4 -> updateMedication(scanner);
                case 5 -> deleteMedication(scanner);
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

    private static void addMedication(Scanner scanner) {
        System.out.print("Enter Visit ID: ");
        int visitId = getUserChoice(scanner);
        scanner.nextLine(); // consume newline

        System.out.print("Enter medication name: ");
        String name = scanner.nextLine();

        System.out.print("Enter dosage instructions: ");
        String dosage = scanner.nextLine();

        String sql = "INSERT INTO Medications(visit_id, name, dosage) VALUES (?, ?, ?)";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, visitId);
            pstmt.setString(2, name);
            pstmt.setString(3, dosage);
            pstmt.executeUpdate();
            System.out.println("Medication added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding medication: " + e.getMessage());
        }
    }

    private static void viewAllMedications() {
        String sql = "SELECT * FROM Medications";

        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- All Medications ---");
            while (rs.next()) {
                System.out.printf("Med ID: %d | Visit ID: %d | Name: %s | Dosage: %s%n",
                        rs.getInt("med_id"),
                        rs.getInt("visit_id"),
                        rs.getString("name"),
                        rs.getString("dosage"));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving medications: " + e.getMessage());
        }
    }

    private static void viewMedicationsByVisit(Scanner scanner) {
        System.out.print("Enter Visit ID: ");
        int visitId = getUserChoice(scanner);

        String sql = "SELECT * FROM Medications WHERE visit_id = ?";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, visitId);
            ResultSet rs = pstmt.executeQuery();
            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.printf("Med ID: %d | Name: %s | Dosage: %s%n",
                        rs.getInt("med_id"),
                        rs.getString("name"),
                        rs.getString("dosage"));
            }
            if (!found) {
                System.out.println("No medications found for this visit.");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving medications: " + e.getMessage());
        }
    }

    private static void updateMedication(Scanner scanner) {
        System.out.print("Enter the ID of the medication to update: ");
        int medId = getUserChoice(scanner);
        scanner.nextLine(); // consume newline

        System.out.print("Enter new name (or press Enter to skip): ");
        String name = scanner.nextLine();

        System.out.print("Enter new dosage (or press Enter to skip): ");
        String dosage = scanner.nextLine();

        String sql = "UPDATE Medications SET "
                + "name = COALESCE(NULLIF(?, ''), name), "
                + "dosage = COALESCE(NULLIF(?, ''), dosage) "
                + "WHERE med_id = ?";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, dosage);
            pstmt.setInt(3, medId);
            int updated = pstmt.executeUpdate();
            if (updated > 0) {
                System.out.println("Medication updated successfully.");
            } else {
                System.out.println("Medication not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating medication: " + e.getMessage());
        }
    }

    private static void deleteMedication(Scanner scanner) {
        System.out.print("Enter the ID of the medication to delete: ");
        int medId = getUserChoice(scanner);

        String sql = "DELETE FROM Medications WHERE med_id = ?";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, medId);
            int deleted = pstmt.executeUpdate();
            if (deleted > 0) {
                System.out.println("Medication deleted successfully.");
            } else {
                System.out.println("Medication not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting medication: " + e.getMessage());
        }
    }
}
