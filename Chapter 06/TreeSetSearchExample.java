import java.util.TreeSet;

public class TreeSetSearchExample {
    public static void main(String[] args) {
        TreeSet<String> spacecraft = new TreeSet<>();
        spacecraft.add("Voyager");
        spacecraft.add("Apollo");
        spacecraft.add("Perseverance");
        spacecraft.add("Hubble");
        spacecraft.add("Artemis");

        // Search for a spacecraft
        if (spacecraft.contains("Hubble")) {
            System.out.println("Hubble is in the TreeSet.");
        } else {
            System.out.println("Hubble is not in the TreeSet.");
        }
    }
}
