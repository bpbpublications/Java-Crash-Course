public class Corgi extends Canine {
    // Attributes
    private String subBreed;

    // Constructor
    public Corgi(String scientificName, String habitat, String breed, String subBreed) {
        super(scientificName, habitat, breed); // Calls the Canine constructor
        this.subBreed = subBreed;
    }

    // Method
    public void herd() {
        System.out.println("The " + subBreed + " Corgi is herding.");
    }

    // Overriding the displayInfo method
    @Override
    public void displayInfo() {
        super.displayInfo(); // Calls displayInfo of Species
        System.out.println("Breed: " + breed + ", Sub-breed: " + subBreed);
    }

    @Override
    public void move() {
        System.out.println("The " + subBreed + " trots with short, bounding steps.");
    }
}
