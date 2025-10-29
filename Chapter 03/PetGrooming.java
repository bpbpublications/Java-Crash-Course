public class PetGrooming {
    public static void main(String[] args) {
        // Creating a Corgi object
        Corgi myCorgi = new Corgi("Canis lupus familiaris", "Domestic", "Corgi", "Pembroke Welsh Corgi");

        // Calling methods
        myCorgi.displayInfo(); // Calls the overridden method in Corgi
        myCorgi.move(); // Calls the method from Animal
        myCorgi.bark(); // Calls the method from Canine
        myCorgi.herd(); // Calls the method in Corgi
    }
}
