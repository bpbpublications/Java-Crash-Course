public class ConstructionSite {
    public static void constructBuilding(Building skyscraper) {
            skyscraper.buildFoundation();
            skyscraper.constructWalls();
            skyscraper.addRoof();
    }

    public static void main(String[] args) {
        BuildingTemplate restaurant = new Restaurant();
        BuildingTemplate bank = new Bank();

        constructBuilding(restaurant);
        constructBuilding(bank);
    }
}