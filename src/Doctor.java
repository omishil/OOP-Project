class Doctor extends Person implements Trackable{

    private String specialization;

    Doctor(String name, int id, int age, String specialization) {

        super(name, id, age);

        this.specialization = specialization;
    }

    String getSpecialization() {
        return specialization;
    }

    @Override
    void displayInfo() {

        System.out.println("Doctor Name: " + getName());
        System.out.println("Doctor ID: " + getId());
        System.out.println("Age: " + getAge());
        System.out.println("Specialization: " + specialization);
    }

    //Surgeon extends Doctor so Surgeon automatically gets the Trackable behavior.
    @Override
    public void markAttendance() {

        System.out.println(getName() + " attendance marked.");
    }

    @Override
    public void showAttendance() {

        System.out.println(getName() + " is present.");
    }
}
