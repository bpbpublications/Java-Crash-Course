import java.util.ArrayList;
import java.util.Collections;

public class SpacecraftSearchExample {
    public static void main(String[] args) {
        // Create and populate the ArrayList
        ArrayList<String> spacecraft = new ArrayList<>();
        spacecraft.add("Voyager");
        spacecraft.add("Apollo");
        spacecraft.add("Perseverance");
        spacecraft.add("Hubble");
        spacecraft.add("Artemis");

        //Collections.sort(spacecraft);

        // Simulate obtaining input from a user
        String missingSpacecraft = "Hubble";

        // Search for specific spacecraft
        int index = Collections.binarySearch(spacecraft, missingSpacecraft);
        if (index >= 0) {
            System.out.println("Found " + missingSpacecraft + " at index: " + index);
        } else {
            System.out.println(missingSpacecraft + " not found in the list.");
        }
    }
}
