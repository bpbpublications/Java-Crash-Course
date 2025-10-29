public class Bird2 extends Animal2 {
    protected String featherColor;

    public Bird2(String scientificName, String habitat, double weight, String featherColor) {
        super(scientificName, habitat, weight);
        this.featherColor = featherColor;
    }

    public void fly() {
        System.out.println("The bird flies through the " + getHabitat());
    }
}