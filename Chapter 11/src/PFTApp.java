import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class PFTApp extends Application {

    private GridPane accountTable;
    private DoubleProperty totalBalance = new SimpleDoubleProperty(0.0);
    private Set<String> savedTransactions = new HashSet<>();


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Personal Finance Tracker");

        // BorderPane layout
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        // BorderPane - Top
        Label titleLabel = new Label("Personal Finance Tracker");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        ImageView logoView = new ImageView(new Image("file:resources/pft_logo.png"));
        logoView.setFitWidth(100);
        logoView.setPreserveRatio(true);

        HBox topBox = new HBox(10, logoView, titleLabel);
        topBox.setPadding(new Insets(10));
        root.setTop(topBox);

        // BorderPane - Left and Right
        root.setLeft(new Label("   ")); 
        root.setRight(new Label("   "));

        // BorderPane - Bottom
        Label copyrightLabel = new Label("© 2025 Personal Finance Tracker");
        HBox bottomBox = new HBox(copyrightLabel);
        bottomBox.setPadding(new Insets(10));
        bottomBox.setStyle("-fx-alignment: center;");

        // BorderPane - Center 
        VBox vbox = new VBox(15);
        vbox.setPadding(new Insets(10));
        vbox.setStyle("-fx-background-color: #f4f4f4; -fx-padding: 15px;");

        // VBox - Transaction Input
        Label transactionLabel = new Label("Enter Transaction Details");
        transactionLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        TextField amountField = new TextField();
        amountField.setPromptText("Enter amount");

        TextField categoryField = new TextField();
        categoryField.setPromptText("Enter category");

        // Live category preview
        Label categoryPreviewLabel = new Label("Category Preview: ");
        categoryPreviewLabel.textProperty().bind(categoryField.textProperty());
        vbox.getChildren().add(categoryPreviewLabel);

        TextField descriptionField = new TextField();
        descriptionField.setPromptText("Enter description");

        // Add elements to VBox
        vbox.getChildren().addAll(transactionLabel, amountField, categoryField, descriptionField);

        // HBox - Buttons
        Button addButton = new Button("Add Transaction");
        // Disable "Add Transaction" button until all fields have content
        addButton.disableProperty().bind(
            amountField.textProperty().isEmpty()
                .or(categoryField.textProperty().isEmpty())
                .or(descriptionField.textProperty().isEmpty())
        );

        Button clearButton = new Button("Clear Fields");
        
        HBox hbox = new HBox(10, addButton, clearButton);
        hbox.setPadding(new Insets(10));

        // Event Handling
        addButton.setOnAction(e -> {
            String amount = amountField.getText();
            String category = categoryField.getText();
            String description = descriptionField.getText();
        
            if (amount.isEmpty() || category.isEmpty() || description.isEmpty()) {
                showAlert("Error", "All fields must be filled.");
            } else {
                addTransactionToTable(amount, category, description, true); 
                categoryField.clear();
                descriptionField.clear();
            }
        });
        
        clearButton.setOnAction(e -> {
            amountField.clear();
            categoryField.clear();
            descriptionField.clear();
        });       

        // Add transaction input and buttons to VBox
        vbox.getChildren().add(hbox);

        // Total balance display
        Label balanceLabel = new Label();
        balanceLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // Bind balanceLabel to totalBalance
        balanceLabel.textProperty().bind(totalBalance.asString("Total Balance: $%.2f"));

        // Add to the VBox before transaction input fields
        vbox.getChildren().add(balanceLabel);

        root.setCenter(vbox);

        // GridPane
        accountTable = new GridPane();
        accountTable.setPadding(new Insets(10));
        accountTable.setHgap(10);
        accountTable.setVgap(10);
        
        // Table Column Headers 
        accountTable.add(new Label("Timestamp"), 0, 0);
        accountTable.add(new Label("Amount ($)"), 1, 0);
        accountTable.add(new Label("Category"), 2, 0);
        accountTable.add(new Label("Description"), 3, 0);
        accountTable.add(new Label("Action"), 4, 0); 

        // VBox for the Bottom
        VBox bottomVBox = new VBox(10, accountTable, bottomBox);
        root.setBottom(bottomVBox);

        loadTransactionsFromFile();

        // Create Scene
        Scene scene = new Scene(root, 720, 480);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

// Load transactions from file
private void loadTransactionsFromFile() {
    // Clear existing rows
    accountTable.getChildren().clear();

    // Add headers again
    accountTable.add(new Label("Timestamp"), 0, 0);
    accountTable.add(new Label("Amount ($)"), 1, 0);
    accountTable.add(new Label("Category"), 2, 0);
    accountTable.add(new Label("Description"), 3, 0);
    accountTable.add(new Label("Action"), 4, 0);

    try (BufferedReader reader = new BufferedReader(new FileReader("transactions.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println("Reading line: " + line);
            String[] parts = line.split(",");
            if (parts.length == 4) {
                // Add the transaction to the table without saving it again
                addTransactionToTable(parts[1], parts[2], parts[3], false); // Ensure the fourth argument is included
                // Add the transaction to the set to avoid duplicates
                savedTransactions.add(line);
            }
        }
    } catch (FileNotFoundException e) {
        System.out.println("No previous transactions found.");
    } catch (IOException ex) {
        showAlert("Error", "Failed to load transactions.");
    }
}




    // Display alerts
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

// Add transaction to table
// include timestamp and option to delete
private void addTransactionToTable(String amount, String category, String description, boolean isNewTransaction) {
    int rowIndex = (accountTable.getChildren().size() - 5) / 5 + 1; // Updated for 5 columns, subtract headers

    // Generate a timestamp
    String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    String transactionLine = timestamp + "," + amount + "," + category + "," + description;

    // Check if the transaction is already saved
    if (isNewTransaction) {
        if (savedTransactions.contains(transactionLine)) {
            return; // Skip if transaction is already saved
        } else {
            savedTransactions.add(transactionLine);
            saveTransactionToFile(transactionLine);
        }
    }

    accountTable.add(new Label(timestamp), 0, rowIndex);
    accountTable.add(new Label(amount), 1, rowIndex);
    accountTable.add(new Label(category), 2, rowIndex);
    accountTable.add(new Label(description), 3, rowIndex);

    // Delete button
    Button deleteButton = new Button("Delete");
    deleteButton.setOnAction(e -> removeTransactionFromTable(rowIndex));
    accountTable.add(deleteButton, 4, rowIndex);

    // Update balance
    try {
        double transactionAmount = Double.parseDouble(amount);
        totalBalance.set(totalBalance.get() + transactionAmount);
    } catch (NumberFormatException e) {
        showAlert("Error", "Invalid amount entered. Please enter a numeric value.");
    }
}



// Helper method to save transaction to file
private void saveTransactionToFile(String transactionLine) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.txt", true))) {
        writer.write(transactionLine);
        writer.newLine();
    } catch (IOException ex) {
        showAlert("Error", "Failed to save transaction.");
    }
}


    // Remove a transaction 
    private void removeTransactionFromTable(int rowIndex) {
        // Find and remove row nodes
        accountTable.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null && GridPane.getRowIndex(node) == rowIndex);

        // Adjust balance
        Label amountLabel = (Label) getNodeByRowColumnIndex(rowIndex, 1, accountTable);
        if (amountLabel != null) {
            try {
                double transactionAmount = Double.parseDouble(amountLabel.getText());
                totalBalance.set(totalBalance.get() - transactionAmount);
            } catch (NumberFormatException e) {
                showAlert("Error", "Invalid amount in table. Please check the data.");
            }
        }

        // Update file
        updateTransactionsFile();
    }

    // Helper method to get node by row and column index
    private Node getNodeByRowColumnIndex(final int row, final int column, GridPane gridPane) {
        Node result = null;
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getRowIndex(node) != null && GridPane.getRowIndex(node) == row &&
                GridPane.getColumnIndex(node) != null && GridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }
        return result;
    }

    // Update transactions file after deletion
    private void updateTransactionsFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.txt"))) {
            // Loop through each row and write transaction data
            for (int i = 1; i <= (accountTable.getChildren().size() / 5); i++) { // skipping the header row
                String timestamp = ((Label) getNodeByRowColumnIndex(i, 0, accountTable)).getText();
                String amount = ((Label) getNodeByRowColumnIndex(i, 1, accountTable)).getText();
                String category = ((Label) getNodeByRowColumnIndex(i, 2, accountTable)).getText();
                String description = ((Label) getNodeByRowColumnIndex(i, 3, accountTable)).getText();
                writer.write(timestamp + "," + amount + "," + category + "," + description);
                writer.newLine();
            }
        } catch (IOException ex) {
            showAlert("Error", "Failed to update transactions file.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
