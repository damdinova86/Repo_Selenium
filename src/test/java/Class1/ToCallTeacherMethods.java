package Class1;

import java.util.Scanner;

public class ToCallTeacherMethods {
    public static void main(String[] args) {

        Scanner scan= new Scanner(System.in);

        System.out.println("Please enter your teacher's ID");
        int typeTeacherId= scan.nextInt();
        System.out.println("Please enter your password");
        int typePassword= scan.nextInt();
      // to catch end of line
       // teacherLogIn T2= new teacherLogIn(typeTeacherId, typePassword);

       // 1. to define how many students teacher wants to have in his class
        System.out.println("Please enter the number of students to assign to your class");
           // T2.numOfStudentsScan();


//        //2. to add students
//
//        T1.addStudentScanner();
//
//        //3. to remove students
//
//        T1.removeStudentScanner();
//
//        //4.Take student attendance mark present, excused absent, unexcused absent
//
//
//        T1.studentsAttendanceScanner();



    }

}
