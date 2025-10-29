public class Animal extends Species {
    // Attributes
    protected String habitat;

    // Constructor
    public Animal(String scientificName, String habitat) {
        super(scientificName); // Calls the constructor of Species
        this.habitat = habitat;
    }

    // Method
    public void move() {
        System.out.println("The animal moves appropriately in its habitat.");
    }
}
