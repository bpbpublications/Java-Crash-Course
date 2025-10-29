public class Dog2 extends Animal2 {
    private String breed;

    public Dog2(String scientificName, String habitat, double weight, String breed) {
        super(scientificName, habitat, weight);
        this.breed = breed;
    }

    // Getter and setter for breed
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}