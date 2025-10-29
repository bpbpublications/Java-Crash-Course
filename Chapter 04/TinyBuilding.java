public class TinyBuilding {
    private String type;

    public TinyBuilding(String type) {
        this.type = type;
    }

    public void openDoor() {
        System.out.println("Opening the door of the " + type);
    }
}