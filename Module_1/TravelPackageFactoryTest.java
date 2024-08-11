package Module_1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TravelPackageFactoryTest {

    @Test
    void testCreateFlightPackage() {
        TravelPackage flightPackage = TravelPackageFactory.createPackage("flight");
        assertNotNull(flightPackage, "Flight package should not be null");
        assertTrue(flightPackage instanceof FlightPackage, "Expected instance of FlightPackage");
    }

    @Test
    void testCreateHotelPackage() {
        TravelPackage hotelPackage = TravelPackageFactory.createPackage("hotel");
        assertNotNull(hotelPackage, "Hotel package should not be null");
        assertTrue(hotelPackage instanceof HotelPackage, "Expected instance of HotelPackage");
    }

    @Test
    void testCreateCarRentalPackage() {
        TravelPackage carRentalPackage = TravelPackageFactory.createPackage("car");
        assertNotNull(carRentalPackage, "Car rental package should not be null");
        assertTrue(carRentalPackage instanceof CarRentalPackage, "Expected instance of CarRentalPackage");
    }

    @Test
    void testCreateInvalidPackage() {
        TravelPackage invalidPackage = TravelPackageFactory.createPackage("cruise");
        assertNull(invalidPackage, "Invalid package type should return null");
    }
}
