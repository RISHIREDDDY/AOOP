package Module_1;

public class Main {
    public static void main(String[] args) {
        // Create the singleton instance of TravelManager
        TravelManager manager = TravelManager.getInstance();

        // Create a subject for booking notifications
        BookingSubject bookingSubject = new BookingSubject();

        // Register users to receive notifications
        User user1 = new User("Alice");
        User user2 = new User("Bob");
        bookingSubject.registerObserver(user1);
        bookingSubject.registerObserver(user2);

        // Book a flight
        manager.bookPackage("flight");

        // Notify users of booking
        bookingSubject.notifyObservers("Your flight has been booked!");

        // Book a hotel
        manager.bookPackage("hotel");

        // Notify users of booking
        bookingSubject.notifyObservers("Your hotel has been booked!");
    }
}
