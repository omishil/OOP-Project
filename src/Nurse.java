import java.util.ArrayList;

class Nurse extends Person implements Trackable {

    private boolean present;

    private ArrayList<String> availableTimes;


    Nurse(String name, int id, int age) {

        super(name, id, age);

        this.present = false;

        availableTimes = new ArrayList<>();
    }


    public void markAttendance(boolean present) {

        this.present = present;
    }


    public boolean isPresent() {

        return present;
    }


    // --------------------------------
    // Add available time
    // --------------------------------

    void addAvailableTime(String time) {

        availableTimes.add(time);
    }


    // --------------------------------
    // Get available times
    // --------------------------------

    ArrayList<String> getAvailableTimes() {

        return availableTimes;
    }


    // --------------------------------
    // Check time availability
    // --------------------------------

    boolean isTimeAvailable(String time) {

        return availableTimes.contains(time);
    }


    // --------------------------------
    // Remove booked time
    // --------------------------------

    void removeAvailableTime(String time) {

        availableTimes.remove(time);
    }


    // --------------------------------
    // Display nurse name in JComboBox
    // --------------------------------

    public String toString() {

        return getName();
    }


    void displayInfo() {

        System.out.println("Nurse: " + getName());
        System.out.println("ID: " + getId());
        System.out.println("Age: " + getAge());
    }
}