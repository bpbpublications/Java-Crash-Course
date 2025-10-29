import java.util.TreeMap;

public class TreeMapSearchExample {
    public static void main(String[] args) {
        TreeMap<String, Integer> spacecraft = new TreeMap<>();
        spacecraft.put("Voyager", 1977);
        spacecraft.put("Apollo", 1968);
        spacecraft.put("Perseverance", 2020);
        spacecraft.put("Hubble", 1990);
        spacecraft.put("Artemis", 2022);

        // Search for a spacecraft by name
        if (spacecraft.containsKey("Hubble")) {
            System.out.println("Hubble is in the TreeMap.");
        } else {
            System.out.println("Hubble is not in the TreeMap.");
        }

        // Search for a launch year
        if (spacecraft.containsValue(1990)) {
            System.out.println("A spacecraft in our collection launched in 1990.");
        } else {
            System.out.println("No spacecraft in our collection launched in 1990.");
        }
    }
}
