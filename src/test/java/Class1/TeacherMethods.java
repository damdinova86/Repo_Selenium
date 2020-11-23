package Class1;

import java.util.HashMap;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class TeacherMethods {

    String id;
    static int SizeOfClass;
    HashMap<String, String> attendance;
    Scanner scan;

    public TeacherMethods(String teacherID, int studentsInClass) {
        numOfStudents(studentsInClass);
        id = teacherID;
      //  attendance = new HashMap<>();
        scan = new Scanner(System.in);
    }
    //1. Can define the numbers of students they have

    public void numOfStudentsScan() {
        int typeNum = scan.nextInt();
        numOfStudents(typeNum);

    }



    public void numOfStudents(int typeNum) {

        if (typeNum > 10) {
            System.out.println("Wrong number! Class should have less than 11 students");
        }
        if (typeNum <= 10) {
            SizeOfClass = typeNum;
            System.out.println("Your class will have " + typeNum + " students");
        }


    }
    //4. Add Students from Admin section

    public void addStudentScanner() {
        for (int i = 1; i <= SizeOfClass; i++) {
            System.out.println("Please type ID# to add student to your class.");
            String typeID = scan.nextLine();
            addStudents(typeID);
        }
    }

    public void addStudents(String typeID) {

        if (attendance.size() < SizeOfClass) {
            attendance.put(typeID, "");
        } else {
            System.out.println("You can't add more than 10 students");
        }
    }


    //Can remove students from their class

    public void removeStudentScanner() {
        System.out.println("If you want to remove one of the student from your class, please enter ID#.");
        String typeIDToRemove = scan.nextLine();
        removeStudent(typeIDToRemove);

    }

    public void removeStudent(String id) {
        attendance.remove(id);
        SizeOfClass-=1;

    }

    //Take student attendance mark present, excused absent, unexcused absent
    public void studentsAttendanceScanner() {
        for (int i = 1; i <= SizeOfClass; i++) {
            System.out.println("To take attendance please enter student's ID");
            String typeIDToTakeAttendance = scan.nextLine();
            System.out.println("Please enter 'absent' or 'excused absent' or 'unexcused absent'");
            String typePresentOrAbsent = scan.nextLine();
            studentsAttendance(typeIDToTakeAttendance, typePresentOrAbsent);

        }
    }
    public void studentsAttendance(String id, String presentOrexcusedabsentOrunexcusedabsent) {
        attendance.put(id, presentOrexcusedabsentOrunexcusedabsent);
        System.out.println("Attendance for the class today: " + attendance);


//        Set<String> allKeys= attendance.keySet();
//        System.out.println(allKeys);


    }


}


