import java.util.ArrayList;

class AttendanceManager {

    private ArrayList<Attendance> attendanceList;
//to store someone's attendance overall
    AttendanceManager() {
        attendanceList = new ArrayList<>();
    }
//now if user wants to store an obj of Attendace that includes name date and status(present or absent) the method for this>>>>>

    void addAttendance(Attendance attendance) {
        attendanceList.add(attendance);
    }
//now if the user wants to display all attendace of one staff he can use --->

    void showAllAttendance() {
//loop through his attendance list
        for (Attendance attendance : attendanceList) {
            attendance.displayAttendance();
            System.out.println();
        }
    }
}