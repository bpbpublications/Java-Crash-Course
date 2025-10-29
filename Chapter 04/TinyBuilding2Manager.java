public class TinyBuilding2Manager {
    public static void main(String[] args) {
        TinyBuilding2 tinyOffice = new TinyBuilding2("Tiny Office");

        tinyOffice.useBuilding();

        // De-reference the object to make it eligible for garbage collection
        tinyOffice = null;

        // Suggest garbage collection
        System.gc();
    }
}