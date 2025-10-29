public class Bank extends BuildingTemplate {

    @Override
    public void constructWalls() {
        System.out.println("Constructing reinforced steel walls for the bank.");
    }

    @Override
    public void addRoof() {
        System.out.println("Adding a steel and concrete roof to the bank.");
    }
}
