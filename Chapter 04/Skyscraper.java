public class Skyscraper implements Building {

    @Override
    public void buildFoundation() {
        System.out.println("Laying a deep concrete foundation for the skyscraper.");
    }

    @Override
    public void constructWalls() {
        System.out.println("Constructing industrial steel and glass walls for the skyscraper.");
    }

    @Override
    public void addRoof() {
        System.out.println("Adding a rooftop terrace for the skyscraper.");
    }
}