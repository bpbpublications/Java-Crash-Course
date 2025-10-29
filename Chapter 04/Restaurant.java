public class Restaurant extends BuildingTemplate {

    @Override
    public void constructWalls() {
        System.out.println("Consstructing brick and mortar walls for the restaurant.");
    }

    @Override
    public void addRoof() {
        System.out.println("Adding a flat-top roof to the restaurant.");
    }

    @Override
    public void buildFoundation() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buildFoundation'");
    }
}
