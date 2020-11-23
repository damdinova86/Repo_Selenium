//package Class1;
//
//import org.testng.annotations.Test;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Scanner;
//public class teacherLogIn {
//    int idTeacher=123;
//    static int sizeOfClass;
//    Scanner scan;
//
//
//    //Teacher's login
//    public teacherLogIn(int teacherID,int password) {
//        scan = new Scanner(System.in);
//        if(teacherID==idTeacher){
//
//        } else System.out.println("Wrong ID, please try again");
//    }
//
//
//        // 1. to define how many students teacher wants to have in his class
//        public void numOfStudentsScan() {
//            int typeNum = scan.nextInt();
//            numOfStudents(typeNum);
//
//        }
//
//    public void numOfStudents(int typeNum) {
//
//            if (typeNum > 10) {
//                System.out.println("Wrong number! Class size should has only 10 students or less");
//            }
//            if (typeNum <= 10) {
//                sizeOfClass = typeNum;
//                System.out.println("Your class will have " + typeNum + " students");
//            }
//        }
//
//
//
//    //Can remove students from their class
//
////    public void removeStudentScanner() {
////        System.out.println("If you want to remove one of the student from your class, please enter ID#.");
////        String typeIDToRemove = scan.nextLine();
////        removeStudent(typeIDToRemove);
//
//    }
//
////    public void removeStudent(String id) {
////        attendance.remove(id);
////        sizeOfClass-=1;
//
////    }
//
//
//
//
//}
