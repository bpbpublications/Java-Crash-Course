import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        // Create and populate TreeMap
        // with spacecraft names and  launch years
        TreeMap<String, Integer> spacecraft = new TreeMap<>();
        spacecraft.put("Voyager", 1977);
        spacecraft.put("Apollo", 1968);
        spacecraft.put("Perseverance", 2020);
        spacecraft.put("Hubble", 1990);
        spacecraft.put("Artemis", 2022);

        // Print the sorted TreeMap
        System.out.println("Sorted Spacecraft (by Name): " + spacecraft);
    }
}
