public class House implements Building {

    @Override
    public void buildFoundation() {
        System.out.println("Laying a shallow concrete foundation for the house.");
    }

    @Override
    public void constructWalls() {
        System.out.println("Constructing brick and mortar walls for the house.");
    }

    @Override
    public void addRoof() {
        System.out.println("Adding a gable roof for the house.");
    }
}