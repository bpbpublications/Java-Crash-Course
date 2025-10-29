import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PMRSDatabaseInitializer {

    private static final String DB_URL = "jdbc:sqlite:pmrs.db";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            if (conn != null) {
                createTables(conn);
                System.out.println("Database and tables created successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Error initializing database: " + e.getMessage());
        }
    }

    private static void createTables(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();

        // Create Pets Table
        String createPetsTable = """
            CREATE TABLE IF NOT EXISTS Pets (
                pet_id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                species TEXT NOT NULL,
                breed TEXT,
                age INTEGER,
                owner_name TEXT NOT NULL
            );
        """;

        // Create MedicalVisits Table
        String createVisitsTable = """
            CREATE TABLE IF NOT EXISTS MedicalVisits (
                visit_id INTEGER PRIMARY KEY AUTOINCREMENT,
                pet_id INTEGER NOT NULL,
                visit_date TEXT NOT NULL,
                reason TEXT,
                notes TEXT,
                FOREIGN KEY(pet_id) REFERENCES Pets(pet_id)
            );
        """;

        // Create Medications Table
        String createMedicationsTable = """
            CREATE TABLE IF NOT EXISTS Medications (
                med_id INTEGER PRIMARY KEY AUTOINCREMENT,
                visit_id INTEGER NOT NULL,
                name TEXT NOT NULL,
                dosage TEXT,
                FOREIGN KEY(visit_id) REFERENCES MedicalVisits(visit_id)
            );
        """;

        stmt.execute(createPetsTable);
        stmt.execute(createVisitsTable);
        stmt.execute(createMedicationsTable);
        stmt.close();
    }
}
