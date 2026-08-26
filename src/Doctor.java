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
//    Doctor d1 = new Doctor("Rahim", 101, 30, "Cardiologist");
//
//d1.addAvailableTime("10:00 AM");
//d1.addAvailableTime("2:00 PM");
//["10:00 AM", "2:00 PM"]

    boolean isTimeAvailable(String time)
    {
        return availableTimes.contains(time);
    }
//    if (d1.isTimeAvailable("10:00 AM")) {
//        System.out.println("Time is available!");
//    }
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