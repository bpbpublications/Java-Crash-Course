import java.util.ArrayList;

public class MyEnhancedForLoopExample {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Kobe");
        names.add("Magic");
        names.add("Kareem");

        // This is an enhanced for-loop
        for (String name : names) {
            System.out.println("Name: " + name);
        }
    }
}
