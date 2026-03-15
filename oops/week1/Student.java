package week1;

public class Student{
    int age;
    double height;
    boolean isStudent;
    char grade;

    void getData(int age , double height ,boolean isStudent, char grade){
        this.age = age;
        this.height = height;
        this.isStudent = isStudent;
        this.grade = grade;
    }

    void displayData(){
        System.out.println("Age: " + age);
        System.out.println("Height: " + height);
        System.out.println("Is Student: " + isStudent);
        System.out.println("Grade: " + grade);
    }

}