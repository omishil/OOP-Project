class Nurse extends Person {

    private String department;

    Nurse(String name, int id, int age, String department) {

        super(name, id, age);

        this.department = department;
    }

    String getDepartment() {
        return department;
    }

    @Override
    void displayInfo() {

        System.out.println("Nurse Name: " + getName());
        System.out.println("Nurse ID: " + getId());
        System.out.println("Age: " + getAge());
        System.out.println("Department: " + department);
    }
}