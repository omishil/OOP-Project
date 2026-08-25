class OtherStaff extends Person implements Trackable {

    private boolean present;

    OtherStaff(String name, int id, int age) {
        super(name, id, age);
        this.present = false;
    }

    public void markAttendance(boolean present) {
        this.present = present;
    }

    public boolean isPresent() {
        return present;
    }void displayInfo() {
        System.out.println("Other Staff: " + getName());
        System.out.println("ID: " + getId());
        System.out.println("Age: " + getAge());
    }
}