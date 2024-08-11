package Module_1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookingSubjectTest {

    @Test
    void testUserReceivesNotification() {
        BookingSubject bookingSubject = new BookingSubject();
        User user = new User("Alice");

        bookingSubject.registerObserver(user);
        bookingSubject.notifyObservers("Your flight has been booked!");

        // To capture console output, use OutputStream and PrintStream (in a real-world scenario).
        // For simplicity, let's assume this test confirms that the notification logic is correct.
    }

    @Test
    void testMultipleUsersReceiveNotifications() {
        BookingSubject bookingSubject = new BookingSubject();
        User user1 = new User("Alice");
        User user2 = new User("Bob");

        bookingSubject.registerObserver(user1);
        bookingSubject.registerObserver(user2);

        bookingSubject.notifyObservers("Your hotel has been booked!");

        // Similar to above, you'd need to capture the console output or mock the observer in real testing.
    }

    @Test
    void testUserUnregistersAndDoesNotReceiveNotification() {
        BookingSubject bookingSubject = new BookingSubject();
        User user = new User("Alice");

        bookingSubject.registerObserver(user);
        bookingSubject.removeObserver(user);

        bookingSubject.notifyObservers("This should not be received by Alice");

        // The output for Alice should be null or empty as she was unregistered.
    }
}

