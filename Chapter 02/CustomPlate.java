import java.util.ArrayList;
import java.util.List;

public class CustomPlate {

    // Variables for plate configuration
    private String plateType;        // Type of plate (e.g., Dinner, Salad, Dessert)
    private String print;            // Print pattern (e.g., Floral, Geometric)
    private String color;            // Color of the plate
    private String material;         // Material (e.g., Porcelain, Glass, Plastic)
    private String engraving;        // Custom engraving text (optional)
    private List<String> additionalOptions; // Any extra customizations (e.g., gold trim, matte finish)
    private double basePrice;
    
    // Constructor
    public CustomPlate() {
        this.additionalOptions = new ArrayList<>();
        this.basePrice = 0.0;
    }

    // Method to set the plate type
    public void setPlateType(String plateType) {
        this.plateType = plateType;
        // Set base price based on the plate type
        switch (plateType.toLowerCase()) {
            case "dinner":
                this.basePrice = 75.00;
                break;
            case "salad":
                this.basePrice = 55.00;
                break;
            case "dessert":
                this.basePrice = 35.00;
                break;
            default:
                System.out.println("Invalid plate type. Please choose 'dinner', 'salad', or 'dessert'.");
                break;
        }
    }

    // Method to set the print pattern
    public void setPrint(String print) {
        this.print = print;
    }

    // Method to set the color of the plate
    public void setColor(String color) {
        this.color = color;
    }

    // Method to set the material of the plate
    public void setMaterial(String material) {
        if (material.equalsIgnoreCase("porcelain") || material.equalsIgnoreCase("glass") || material.equalsIgnoreCase("plastic")) {
            this.material = material;
        } else {
            System.out.println("Invalid material type. Please choose 'Porcelain', 'Glass', or 'Plastic'.");
        }
    }

    // Method to add custom engraving (optional)
    public void setEngraving(String engraving) {
        if (engraving.length() <= 30) {  // Limit engraving text to 30 characters
            this.engraving = engraving;
        } else {
            System.out.println("Engraving text too long. Please keep it under 30 characters.");
        }
    }

    // Method to add additional customizations (like gold trim, matte finish, etc.)
    public void addAdditionalOption(String option) {
        this.additionalOptions.add(option);
    }

    // Method to calculate the total cost of the custom plate
    public double calculateCost() {
        double totalCost = this.basePrice;
        
        // Additional costs based on customizations
        if (this.engraving != null && !this.engraving.isEmpty()) {
            totalCost += 5.00;  // Engraving costs $5.00
        }

        // Add $3.00 for each additional option
        totalCost += this.additionalOptions.size() * 3.00;

        return totalCost;
    }

    // Method to display the plate details
    public void displayPlateDetails() {
        if (this.plateType == null || this.print == null || this.color == null || this.material == null) {
            System.out.println("Please complete the plate configuration.");
            return;
        }

        System.out.println("Plate Type: " + this.plateType);
        System.out.println("Print: " + this.print);
        System.out.println("Color: " + this.color);
        System.out.println("Material: " + this.material);
        
        if (this.engraving != null && !this.engraving.isEmpty()) {
            System.out.println("Engraving: " + this.engraving);
        } else {
            System.out.println("No engraving.");
        }

        if (this.additionalOptions.isEmpty()) {
            System.out.println("No additional customizations.");
        } else {
            System.out.println("Additional Customizations: " + String.join(", ", this.additionalOptions));
        }

        System.out.printf("Total Cost: $%.2f%n", calculateCost());
    }

    // Main method to test the CustomPlate class
    public static void main(String[] args) {
        // Create a new CustomPlate instance
        CustomPlate customPlate = new CustomPlate();
        
        // Set plate configuration
        customPlate.setPlateType("Dinner");
        customPlate.setPrint("Floral");
        customPlate.setColor("Blue");
        customPlate.setMaterial("Porcelain");
        customPlate.setEngraving("Happy Birthday");
        customPlate.addAdditionalOption("Gold Trim");
        customPlate.addAdditionalOption("Matte Finish");
        
        // Display the plate details
        customPlate.displayPlateDetails();
    }
}
