public class ConstructionCompany {

    public static void main(String[] args) {
        Building skyscraper = new Skyscraper();
        Building house = new House();
    
        ConstructionSite.constructBuilding(skyscraper);
        ConstructionSite.constructBuilding(house);
    }
}
