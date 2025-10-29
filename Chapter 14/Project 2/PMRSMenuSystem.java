import java.util.Scanner;

public class PMRSMenuSystem {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            showMainMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1 -> PetManager.showMenu(scanner);
                case 2 -> VisitManager.showMenu(scanner);
                case 3 -> MedicationManager.showMenu(scanner);
                case 4 -> {
                    System.out.println("Exiting application. Goodbye!");
                    exit = true;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    // Main Menu
    private static void showMainMenu() {
        System.out.println("\n=== Pet Medical Record System ===");
        System.out.println("1. Manage Pets");
        System.out.println("2. Manage Medical Visits");
        System.out.println("3. Manage Medications");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    // Pets Menu
    private static void managePetsMenu() {
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

            int choice = getUserChoice();
            switch (choice) {
                case 1 -> System.out.println(">> [Placeholder] Add New Pet");
                case 2 -> System.out.println(">> [Placeholder] View All Pets");
                case 3 -> System.out.println(">> [Placeholder] Search for Pet by Name");
                case 4 -> System.out.println(">> [Placeholder] Update Pet Information");
                case 5 -> System.out.println(">> [Placeholder] Delete Pet Record");
                case 6 -> back = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Visits Menu
    private static void manageVisitsMenu() {
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

            int choice = getUserChoice();
            switch (choice) {
                case 1 -> System.out.println(">> [Placeholder] Add New Visit for a Pet");
                case 2 -> System.out.println(">> [Placeholder] View All Visits");
                case 3 -> System.out.println(">> [Placeholder] View Visits by Pet ID");
                case 4 -> System.out.println(">> [Placeholder] Update Visit Details");
                case 5 -> System.out.println(">> [Placeholder] Delete Visit Record");
                case 6 -> back = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Medications Menu
    private static void manageMedicationsMenu() {
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

            int choice = getUserChoice();
            switch (choice) {
                case 1 -> System.out.println(">> [Placeholder] Add Medication for a Visit");
                case 2 -> System.out.println(">> [Placeholder] View All Medications");
                case 3 -> System.out.println(">> [Placeholder] View Medications by Visit ID");
                case 4 -> System.out.println(">> [Placeholder] Update Medication Details");
                case 5 -> System.out.println(">> [Placeholder] Delete Medication Record");
                case 6 -> back = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Input Helper
    private static int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next(); // discard non-integer input
        }
        return scanner.nextInt();
    }
}
