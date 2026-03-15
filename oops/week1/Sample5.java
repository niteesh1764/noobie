package week1;

import java.util.*;

public class Sample5{
    public static void main(String[] args){
        Student stud1 = new Student();
        Scanner sc = new Scanner(System.in);
        int age;
        double height;
        boolean isStudent;
        char grade;
        System.out.println("Enter Age: ");
        age = sc.nextInt();
        System.out.println("Enter Height: ");
        height = sc.nextDouble();
        System.out.println("Enter isStudent: ");
        isStudent = sc.nextBoolean();
        System.out.println("Enter Grade: ");
        grade = sc.next().charAt(0);
        stud1.getData(age,height,isStudent,grade);
        stud1.displayData();
        sc.close();
    }
}