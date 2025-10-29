import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorExample {
    public static void main(String[] args) {
        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Exotic Shorthair"));
        cats.add(new Cat("Maine Coon"));
        cats.add(new Cat("Devon Rex"));
        cats.add(new Cat("Persian"));
        cats.add(new Cat("Ragdoll"));

        // Custom Comparator for sorting by cat breed name length
        Comparator<Cat> lengthComparator = new Comparator<Cat>() {
            @Override
            public int compare(Cat c1, Cat c2) {
                return Integer.compare(c1.getBreed().length(), c2.getBreed().length());
            }
        };

        Collections.sort(cats, lengthComparator);
        System.out.println("Sorted Cats by Breed Name Length: " + cats);
    }
}