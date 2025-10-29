public class MixedUseBuilding implements Residential, Commercial {

    @Override
    public void addConferenceRooms() {
       System.out.println("Adding a conference room and office spaces.");
    }

    @Override
    public void addReceptionAreas() {
        System.out.println("Adding a reception area near the front entrance.");
    }

    @Override
    public void addBedrooms() {
        System.out.println("Adding residential apartments with bedrooms.");
    }

    @Override
    public void addKitchen() {
        System.out.println("Adding kitchens for each apartment.");
    }
}
