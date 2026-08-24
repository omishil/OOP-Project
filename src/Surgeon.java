class Surgeon extends Doctor {

    private String surgeryType;

    Surgeon(String name, int id, int age,
            String specialization, String surgeryType) {

        super(name, id, age, specialization);

        this.surgeryType = surgeryType;
    }

    String getSurgeryType() {
        return surgeryType;
    }

    @Override
    void displayInfo() {

        System.out.println("Surgeon Name: " + getName());
        System.out.println("Surgeon ID: " + getId());
        System.out.println("Age: " + getAge());
        System.out.println("Specialization: " + getSpecialization());
        System.out.println("Surgery Type: " + surgeryType);
    }
    //as surgeon extends dc so the interface isnt coded here again
    //it can so use the methods of trackable interface here
}