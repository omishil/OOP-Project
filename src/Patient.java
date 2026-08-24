class Patient {

    private String name;
    private int age;
    private String disease;
    private String phone;

    Patient(String name, int age, String disease, String phone) {
        this.name = name;
        this.age = age;
        this.disease = disease;
        this.phone = phone;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    String getDisease() {
        return disease;
    }

    String getPhone() {
        return phone;
    }

    void displayInfo() {
        System.out.println("Patient Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Disease: " + disease);
        System.out.println("Phone: " + phone);
    }
}