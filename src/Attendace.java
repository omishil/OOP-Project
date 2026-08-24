class Attendance {

    private int staffId;
    private String date;
    private String status;

    Attendance(int staffId, String date, String status) {
        this.staffId = staffId;
        this.date = date;
        this.status = status;
    }

    int getStaffId() {
        return staffId;
    }

    String getDate() {
        return date;
    }

    String getStatus() {
        return status;
    }

    void displayAttendance() {

        System.out.println("Staff ID: " + staffId);
        System.out.println("Date: " + date);
        System.out.println("Status: " + status);
    }
}