import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        // Create and populate a TreeSet 
        TreeSet<String> spacecraft = new TreeSet<>();
        spacecraft.add("Voyager");
        spacecraft.add("Apollo");
        spacecraft.add("Perseverance");
        spacecraft.add("Hubble");
        spacecraft.add("Artemis");

        // Print the sorted TreeSet
        System.out.println("Sorted Spacecraft: " + spacecraft);

        // Attempt to add a duplicate item
        spacecraft.add("Apollo");
        System.out.println("After Adding Duplicate: " + spacecraft); 
    }
}
