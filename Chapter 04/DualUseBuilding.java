public class DualUseBuilding implements Building, Residential, Commercial {

    @Override
    public void buildFoundation() {
        System.out.println("Laying a shared foundation for mixed-use building.");
    }

    @Override
    public void constructWalls() {
        System.out.println("Constructing walls for mixed-use spaces.");
    }

    @Override
    public void addRoof() {
        System.out.println("Adding a shared roof for mixed-use building.");
    }

    @Override
    public void addBedrooms() {
        System.out.println("Adding residential apartments.");
    }

    @Override
    public void addConferenceRooms() {
        System.out.println("Adding office spaces with conference rooms.");
    }

    @Override
    public void addReceptionAreas() {
        System.out.println("Adding reception areas for each suite.");
    }

    @Override
    public void addKitchen() {
        System.out.println("Adding kitchen area for each suite.");
    }
}
