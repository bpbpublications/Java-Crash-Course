public abstract class BuildingTemplate implements Building {
    // Concrete Method: Shared implementation
    public void constructFoundation() {
        System.out.println("Constructing a standard concrete foundation.");
    }

    // Abstract Methods: Must be implemented by subclasses
    public abstract void constructWalls();

    public abstract void addRoof();
}
