public class Canine extends Animal {
    // Attributes
    protected String breed;

    // Constructor
    public Canine(String scientificName, String habitat, String breed) {
        super(scientificName, habitat); // Calls the constructor of Animal
        this.breed = breed;
    }

    // Method
    public void bark() {
        System.out.println("The dog barked.");
    }

    @Override
    public void move() {
        System.out.println("The dog runs around playfully in its habitat.");
    }
}
