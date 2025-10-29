public class Animal2 extends Species {
    // Private attributes (encapsulation)
    private String habitat;
    private double weight;

    // Constructor
    public Animal2(String scientificName, String habitat, double weight) {
        super(scientificName);
        this.habitat = habitat;
        this.weight = weight;
    }

    // Method
    public void move() {
        System.out.println("The animal moves appropriately in its habitat.");
    }

    // Getter and setter for habitat
    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    // Getter and setter for weight
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight > 0) { // Simple validation
            this.weight = weight;
        }
    }
}