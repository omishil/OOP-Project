import java.util.ArrayList;

class Doctor extends Person implements Trackable {

    private String specialization;
    private boolean present;
    private ArrayList<String> availableTimes;
    Doctor(String name, int id, int age, String specialization) {
        super(name, id, age);
        this.specialization = specialization;
        this.present = false;
        this.availableTimes = new ArrayList<>();
    }
    void addAvailableTime(String time) {
        availableTimes.add(time);
    }
    boolean isTimeAvailable(String time) {
        return availableTimes.contains(time);
    }
    public void markAttendance(boolean present) {
        this.present = present;
    }

    public boolean isPresent() {
        return present;
    }

    public String getSpecialization() {
        return specialization;
    }void displayInfo() {
        System.out.println("Doctor: " + getName());
        System.out.println("ID: " + getId());
        System.out.println("Age: " + getAge());
        System.out.println("Specialization: " + specialization);
    }
    //to display dc names in gui dropbox
    @Override
    public String toString() {
        return getName();
    }
}