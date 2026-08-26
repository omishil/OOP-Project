class Nurse extends Person {

    boolean present;

    Nurse(String name, int id, int age) {
        super(name, id, age);
        this.present = false;
    }

    public void markAttendance(boolean present) {
        this.present = present;
    }

    public boolean isPresent() {
        return present;
    }

    void displayInfo() {
        System.out.println("Nurse: " + getName());
        System.out.println("ID: " + getId());
        System.out.println("Age: " + getAge());
    }
}