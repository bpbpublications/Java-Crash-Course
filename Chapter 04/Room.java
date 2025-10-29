public class Room {
    private TinyBuilding building;

    public void assignBuilding(TinyBuilding building) {
        this.building = building;
    }

    public void releaseBuilding() {
        this.building = null; // Release reference
    }
}
