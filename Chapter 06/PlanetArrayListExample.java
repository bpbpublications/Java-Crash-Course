import java.util.ArrayList;

public class PlanetArrayListExample {
    public static void main(String[] args) {
        // Declare and initialize an ArrayList
        ArrayList<String> planets = new ArrayList<>();

        // Add elements to the ArrayList
        planets.add("Mercury");
        planets.add("Venus");
        planets.add("Earth");
        planets.add("Mars");
        planets.add("Jupiter");
        planets.add("Saturn");
        planets.add("Uranus");
        planets.add("Neptune");
        planets.add("Pluto");

        // Access and print elements
        System.out.println("First planet: " + planets.get(0)); 

        // Remove an element
        planets.remove("Pluto");

        // Iterate through the ArrayList
        for (String planet : planets) {
            System.out.println(planet);
        }
    }
}
