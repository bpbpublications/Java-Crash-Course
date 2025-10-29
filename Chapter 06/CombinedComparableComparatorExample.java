import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CombinedComparableComparatorExample {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Elephant", 25));
        animals.add(new Animal("Zebra", 12));
        animals.add(new Animal("Lion", 15));
        animals.add(new Animal("Giraffe", 10));

        // Sort by natural order (name)
        Collections.sort(animals);
        System.out.println("Sorted Animals by Name: " + animals);

        // Custom Comparator to sort by age
        Comparator<Animal> ageComparator = new Comparator<Animal>() {
            @Override
            public int compare(Animal a1, Animal a2) {
                return Integer.compare(a1.getAge(), a2.getAge());
            }
        };

        Collections.sort(animals, ageComparator);
        System.out.println("Sorted Animals by Age: " + animals);
    }
}