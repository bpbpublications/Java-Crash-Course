import java.util.ArrayList;
import java.util.Collections;

public class ComparableExample {
    public static void main(String[] args) {
        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Corgi"));
        dogs.add(new Dog("Beagle"));
        dogs.add(new Dog("Labrador"));
        dogs.add(new Dog("Dalmatian"));
        dogs.add(new Dog("Poodle"));

        Collections.sort(dogs); // Sort using Comparable
        System.out.println("Sorted Dogs by Name: " + dogs);
    }
}