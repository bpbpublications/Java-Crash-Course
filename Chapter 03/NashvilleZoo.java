public class NashvilleZoo {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();

        Animal genericAnimal = new Animal("Generic species", "various habitats");
        Animal dog = new Canine("Canis lupus familiaris", "Domestic", "Mixed breed");
        Animal corgi = new Corgi("Canis lupus familiaris", "Domestic", "Corgi", "Pembroke Welsh Corgi");

        zoo.animalMovement(genericAnimal);
        zoo.animalMovement(dog);
        zoo.animalMovement(corgi);
    }
}
