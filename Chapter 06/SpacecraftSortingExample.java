import java.util.ArrayList;
import java.util.Collections;

public class SpacecraftSortingExample {
    public static void main(String[] args) {
        // Create and populate the ArrayList
        ArrayList<String> spacecraft = new ArrayList<>();
        spacecraft.add("Voyager");
        spacecraft.add("Apollo");
        spacecraft.add("Perseverance");
        spacecraft.add("Hubble");
        spacecraft.add("Artemis");

        // Sort in 'natural' order
        Collections.sort(spacecraft);
        System.out.println("Spacecraft (Natural Order): " + spacecraft);

        // Sort in reverse order
        spacecraft.sort(Collections.reverseOrder());
        System.out.println("Spacecraft (Reverse Order): " + spacecraft);
    }
}
