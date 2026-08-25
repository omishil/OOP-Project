class Test {
    public static void main(String[] args) {

        Doctor doctor = new Doctor("Rahim", 101, 40, "Cardiology");
        Nurse nurse = new Nurse("Karim", 201, 30);
        Surgeon surgeon = new Surgeon("Hasan", 301, 45, "Neurosurgery");
        OtherStaff staff = new OtherStaff("Rafi", 401, 35);

        // Display information
        doctor.displayInfo();
        System.out.println();

        nurse.displayInfo();
        System.out.println();

        surgeon.displayInfo();
        System.out.println();

        staff.displayInfo();
        System.out.println();

        // Attendance
        doctor.markAttendance(true);
        nurse.markAttendance(true);
        surgeon.markAttendance(false);
        staff.markAttendance(true);

        System.out.println("Doctor present: " + doctor.isPresent());
        System.out.println("Nurse present: " + nurse.isPresent());
        System.out.println("Surgeon present: " + surgeon.isPresent());
        System.out.println("Other Staff present: " + staff.isPresent());
    }
}