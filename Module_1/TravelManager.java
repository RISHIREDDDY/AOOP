package Module_1;

class TravelManager {
    private static TravelManager instance;

    private TravelManager() {
        // Private constructor to prevent instantiation
    }

    public static TravelManager getInstance() {
        if (instance == null) {
            instance = new TravelManager();
        }
        return instance;
    }

    public void bookPackage(String type) {
        TravelPackage travelPackage = TravelPackageFactory.createPackage(type);
        if (travelPackage != null) {
            travelPackage.book();
        } else {
            System.out.println("Invalid package type!");
        }
    }
}