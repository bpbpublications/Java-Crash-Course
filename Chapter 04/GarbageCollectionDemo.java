public class GarbageCollectionDemo {
    public static void main(String[] args) {
        TinyBuilding shed = new TinyBuilding("Shed");
        shed = null; // Eligible for garbage collection
        System.gc(); // Suggest garbage collection (not guaranteed)
    }
}