import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Event {
    private String eventID;
    private String eventName;
    private String eventVenue;
    private LocalDate eventDate;
    private ArrayList<String> eventAttendees;

    public Event(String eventID, String eventName, String eventVenue, LocalDate eventDate) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.eventVenue = eventVenue;
        this.eventDate = eventDate;
        this.eventAttendees = new ArrayList<>();
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public ArrayList<String> getEventAttendees() {
        return eventAttendees;
    }

    public void setEventAttendees(ArrayList<String> eventAttendees) {
        this.eventAttendees = eventAttendees;
    }

    public void organizeEvent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Event ID: ");
        eventID = scanner.nextLine();

        System.out.print("Enter Event Name: ");
        eventName = scanner.nextLine();

        System.out.print("Enter Event Venue: ");
        eventVenue = scanner.nextLine();

        System.out.print("Enter Event Date (yyyy-mm-dd): ");
        eventDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter the number of attendees: ");
        int numAttendees = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numAttendees; i++) {
            System.out.print("Enter Attendee Name: ");
            String attendeeName = scanner.nextLine();
            eventAttendees.add(attendeeName);
        }

        System.out.println("Event organized successfully!");
    }

    public void addAttendee(String attendeeName) {
        eventAttendees.add(attendeeName);
    }

    public void removeAttendee(String attendeeName) {
        eventAttendees.remove(attendeeName);
    }

    public void updateAttendee(int index, String attendeeName) {
        eventAttendees.set(index, attendeeName);
    }

    public String findAttendee(String attendeeName) {
        if (eventAttendees.contains(attendeeName)) {
            return "Attendee found!";
        } else {
            return "Attendee not found!";
        }
    }

    public int getTotalAttendees() {
        return eventAttendees.size();
    }

    @Override
    public String toString() {
        return "Event ID: " + eventID +
                "\nEvent Name: " + eventName +
                "\nEvent Venue: " + eventVenue +
                "\nEvent Date: " + eventDate +
                "\nTotal Attendees: " + eventAttendees.size();
    }

    public static void main(String[] args) {
        Event event = new Event("", "", "", null);
        event.organizeEvent();
        System.out.println(event);

        // Example of using other methods:
        event.addAttendee("John");
        event.addAttendee("Alice");
        System.out.println("Total attendees: " + event.getTotalAttendees());
        System.out.println("Attendee list: " + event.getEventAttendees());
        event.removeAttendee("Alice");
        System.out.println("Total attendees after removal: " + event.getTotalAttendees());
        event.updateAttendee(0, "Johnny");
        System.out.println("Updated attendee list: " + event.getEventAttendees());
        System.out.println("Finding attendee 'John': " + event.findAttendee("John"));
    }
}
