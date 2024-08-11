package Module_1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TravelManagerTest {

    @Test
    void testSingletonInstance() {
        TravelManager instance1 = TravelManager.getInstance();
        TravelManager instance2 = TravelManager.getInstance();
        assertSame(instance1, instance2, "Both instances should be the same");
    }

    @Test
    void testSingletonBehavior() {
        TravelManager instance1 = TravelManager.getInstance();
        TravelManager instance2 = TravelManager.getInstance();
        instance1.bookPackage("flight");
        instance2.bookPackage("hotel");

        assertSame(instance1, instance2, "The singleton instance should manage both bookings");
    }
}
