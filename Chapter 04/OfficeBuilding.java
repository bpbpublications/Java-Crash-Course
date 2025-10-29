public class OfficeBuilding implements Building {

    @Override
    public void buildFoundation() {
        System.out.println("Constructing a deep foundation for the office building.");
    }

    @Override
    public void constructWalls() {
        System.out.println("Constructing steel and glass walls for the officebuilding.");
    }

    @Override
    public void addRoof() {
        System.out.println("Adding a roof to the office building.");
    }

    public static void main(String[] args) {
        Building office = new OfficeBuilding();

        office.addBathrooms(); // Uses the default implementation
    }
}
