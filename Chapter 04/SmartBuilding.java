public class SmartBuilding implements Sustainable, SmartSystems, Security {

    @Override
    public void installSolarPanels() {
        System.out.println("Installing rooftop solar panels.");
    }

    @Override
    public void enableSmartLighting() {
        System.out.println("Enabling smart lighting for energy efficiency.");
    }

    @Override
    public void addSurveillance() {
        System.out.println("Adding high-resolution surveillance cameras.");
    }
}