import java.util.ArrayList;
import java.util.Iterator;

public class MyIteratorExample {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Kobe");
        names.add("Magic");
        names.add("Kareem");
        names.add("Shaq");

        // Create an iterator for the list
        Iterator<String> iterator = names.iterator();

        // Iterate through the list
        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println("Name: " + name);

            // Remove an element (optional)
            if (name.equals("Shaq")) {
                iterator.remove();
            }
        }

        System.out.println("Updated List: " + names); 
    }
}
