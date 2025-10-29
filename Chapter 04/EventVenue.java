public class EventVenue implements Concert, Conference, Exhibition {

    @Override
    public void setupAcousticSystem() {
        System.out.println("Setting up acoustic panels for the concert.");
    }

    @Override
    public void setupProjectionSystem() {
        System.out.println("Setting up projection system for conference.");
    }

    @Override
    public void configureOpenFloorPlan() {
        System.out.println("Providing an open floor plan for exhibitions.");
    }
}
