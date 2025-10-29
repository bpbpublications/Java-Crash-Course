public class Species {
    // Attributes
    protected String scientificName;

    // Constructor
    public Species(String scientificName) {
        this.scientificName = scientificName;
    }

    // Method
    public void displayInfo() {
        System.out.println("Species: " + scientificName);
    }
}
