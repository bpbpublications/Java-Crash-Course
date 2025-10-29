public interface Building {
    void buildFoundation();
    void constructWalls();
    void addRoof();

    default void addBathrooms() {
        System.out.println("Adding bathrooms to the building.");
    }
}