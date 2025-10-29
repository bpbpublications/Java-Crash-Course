public class AnimalSanctuary {
    public static void main(String[] args) {
        Animal genericAnimal = new Animal("Generic species", "various habitats");
        Animal dogAnimal = new Canine("Canis lupus familiaris", "Domestic", "Mixed breed");
        Animal corgiAnimal = new Corgi("Canis lupus familiaris", "Domestic", "Corgi", "Pembroke Welsh Corgi");

        genericAnimal.move(); // Calls Animal's move() method
        dogAnimal.move();     // Calls Canine's move() method due to polymorphism
        corgiAnimal.move();    // Calls Corgi's move() method due to polymorphism
    }
}
