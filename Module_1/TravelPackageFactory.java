package Module_1;

class TravelPackageFactory {
    public static TravelPackage createPackage(String type) {
        switch (type.toLowerCase()) {
            case "flight":
                return new FlightPackage();
            case "hotel":
                return new HotelPackage();
            case "car":
                return new CarRentalPackage();
            default:
                return null;
        }
    }
}