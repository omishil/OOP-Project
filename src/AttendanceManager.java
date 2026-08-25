//import java.util.ArrayList;
//import java.util.HashMap;
//
//class AttendanceManager {
//
//    private HashMap<Integer, ArrayList<Attendance>> attendanceMap;
//
//    AttendanceManager() {
//
//        attendanceMap = new HashMap<>();
//    }
//
//    void addAttendance(Attendance attendance) {
//
//        int staffId = attendance.getStaffId();
//
//        if (!attendanceMap.containsKey(staffId)) {
//
//            attendanceMap.put(
//                    staffId,
//                    new ArrayList<>()
//            );
//        }
//
//        attendanceMap.get(staffId).add(attendance);
//    }
//
//    void showStaffAttendance(int staffId) {
//
//        if (!attendanceMap.containsKey(staffId)) {
//
//            System.out.println("No attendance records found.");
//            return;
//        }
//
//        ArrayList<Attendance> records =
//                attendanceMap.get(staffId);
//
//        for (Attendance attendance : records) {
//
//            attendance.displayAttendance();
//            System.out.println();
//        }
//    }
//}