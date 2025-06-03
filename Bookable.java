
public interface Bookable {
    void book(int SessionID, String participantName); //Method to book
    void cancel(int SessionID, String participantName); //Method to cancel
}