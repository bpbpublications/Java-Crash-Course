import java.sql.*;
import java.util.Scanner;

public class PetManager {

    private static final String DB_URL = "jdbc:sqlite:pmrs.db";

    public static void showMenu(Scanner scanner) {
        boolean back = false;

        while (!back) {
            System.out.println("\n--- Manage Pets ---");
            System.out.println("1. Add New Pet");
            System.out.println("2. View All Pets");
            System.out.println("3. Search for Pet by Name");
            System.out.println("4. Update Pet Information");
            System.out.println("5. Delete Pet Record");
            System.out.println("6. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = getUserChoice(scanner);
            switch (choice) {
                case 1 -> addPet(scanner);
                case 2 -> viewAllPets();
                case 3 -> searchPetByName(scanner);
                case 4 -> updatePet(scanner);
                case 5 -> deletePet(scanner);
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

    private static void addPet(Scanner scanner) {
        scanner.nextLine(); // consume leftover newline
        System.out.print("Enter pet name: ");
        String name = scanner.nextLine();
        System.out.print("Enter species: ");
        String species = scanner.nextLine();
        System.out.print("Enter breed: ");
        String breed = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = getUserChoice(scanner);
        scanner.nextLine(); // consume leftover newline
        System.out.print("Enter owner's name: ");
        String owner = scanner.nextLine();

        String sql = "INSERT INTO Pets(name, species, breed, age, owner_name) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, species);
            pstmt.setString(3, breed);
            pstmt.setInt(4, age);
            pstmt.setString(5, owner);
            pstmt.executeUpdate();
            System.out.println("Pet added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding pet: " + e.getMessage());
        }
    }

    private static void viewAllPets() {
        String sql = "SELECT * FROM Pets";

        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- All Pets ---");
            while (rs.next()) {
                System.out.printf("ID: %d | Name: %s | Species: %s | Breed: %s | Age: %d | Owner: %s%n",
                        rs.getInt("pet_id"),
                        rs.getString("name"),
                        rs.getString("species"),
                        rs.getString("breed"),
                        rs.getInt("age"),
                        rs.getString("owner_name"));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving pets: " + e.getMessage());
        }
    }

    private static void searchPetByName(Scanner scanner) {
        scanner.nextLine(); // consume leftover newline
        System.out.print("Enter pet name to search: ");
        String keyword = scanner.nextLine();

        String sql = "SELECT * FROM Pets WHERE name LIKE ?";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + keyword + "%");
            ResultSet rs = pstmt.executeQuery();
            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.printf("ID: %d | Name: %s | Species: %s | Breed: %s | Age: %d | Owner: %s%n",
                        rs.getInt("pet_id"),
                        rs.getString("name"),
                        rs.getString("species"),
                        rs.getString("breed"),
                        rs.getInt("age"),
                        rs.getString("owner_name"));
            }
            if (!found) System.out.println("No matching pets found.");
        } catch (SQLException e) {
            System.out.println("Error searching pets: " + e.getMessage());
        }
    }

    private static void updatePet(Scanner scanner) {
        System.out.print("Enter the ID of the pet to update: ");
        int id = getUserChoice(scanner);
        scanner.nextLine(); // consume newline

        System.out.print("Enter new name (or press Enter to skip): ");
        String name = scanner.nextLine();
        System.out.print("Enter new species (or press Enter to skip): ");
        String species = scanner.nextLine();
        System.out.print("Enter new breed (or press Enter to skip): ");
        String breed = scanner.nextLine();
        System.out.print("Enter new age (or -1 to skip): ");
        int age = getUserChoice(scanner);
        scanner.nextLine(); // consume newline
        System.out.print("Enter new owner name (or press Enter to skip): ");
        String owner = scanner.nextLine();

        String sql = "UPDATE Pets SET "
                + "name = COALESCE(NULLIF(?, ''), name), "
                + "species = COALESCE(NULLIF(?, ''), species), "
                + "breed = COALESCE(NULLIF(?, ''), breed), "
                + "age = CASE WHEN ? >= 0 THEN ? ELSE age END, "
                + "owner_name = COALESCE(NULLIF(?, ''), owner_name) "
                + "WHERE pet_id = ?";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, species);
            pstmt.setString(3, breed);
            pstmt.setInt(4, age);
            pstmt.setInt(5, age);
            pstmt.setString(6, owner);
            pstmt.setInt(7, id);
            int updated = pstmt.executeUpdate();
            if (updated > 0) {
                System.out.println("Pet updated successfully.");
            } else {
                System.out.println("Pet not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating pet: " + e.getMessage());
        }
    }

    private static void deletePet(Scanner scanner) {
        System.out.print("Enter the ID of the pet to delete: ");
        int id = getUserChoice(scanner);

        String sql = "DELETE FROM Pets WHERE pet_id = ?";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int deleted = pstmt.executeUpdate();
            if (deleted > 0) {
                System.out.println("Pet deleted successfully.");
            } else {
                System.out.println("Pet not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting pet: " + e.getMessage());
        }
    }
}
