public class Zoo2 {
    public static void main(String[] args) {
        // Creating instances
        Animal2 genericAnimal = new Animal2("Canis lupus", "Forests", 70.5);
        Dog2 dog = new Dog2("Canis lupus familiaris", "Domestic", 12.5, "Labrador");
        Bird2 bird = new Bird2("Corvus corax", "Mountains", 1.2, "Black");

        // Accessing public methods
        System.out.println("Animal habitat: " + genericAnimal.getHabitat());
        System.out.println("Dog breed: " + dog.getBreed());
        System.out.println("Bird feather color: " + bird.featherColor); // Allowed because of protected access

        // Modifying attributes through public setters
        genericAnimal.setWeight(75.0);
        System.out.println("Updated weight: " + genericAnimal.getWeight());

        // Attempting direct access to private attribute (will result in an error if uncommented)
        // dog.weight = 15.0;

        // Calling public methods
        dog.move();
        bird.fly();
    }
}
