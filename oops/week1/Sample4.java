package week1;
    public class Sample4 {
        int age = 25;
        double height = 5.8;
        boolean isStudent = true;
        char grade = 'A';

        static public void main(String[] args) {
        // TODO Auto-generated method stub
        //final int x = 10;
            Sample4 ob1 = new Sample4();
            Sample4 ob2 = new Sample4();
            System.out.println("Object1 details");
            System.out.println("Age: " + ob1.age);
            System.out.println("Height: " +ob1.height);
            System.out.println("Is Student? " +ob1.isStudent);
            System.out.println("Grade: " + ob1.grade);
            System.out.println("Object2 details");
            System.out.println("Age: " + ob2.age);
            System.out.println("Height: " +ob2.height);
            System.out.println("Is Student? " +ob2.isStudent);
            System.out.println("Grade: " + ob2.grade);
            //ob1=ob2;
            ob2.age = 35;
            ob2.height=6.0;
            ob2.isStudent = false;
            ob2.grade= 'B';
            System.out.println("Object1 details fresh");
            System.out.println("Age: " + ob1.age);
            System.out.println("Height: " +ob1.height);
            System.out.println("Is Student? " + ob1.isStudent);
            System.out.println("Grade: " + ob1.grade);
            System.out.println("Object2 details");
            System.out.println("Age: " + ob2.age);
            System.out.println("Height: " + ob2.height);
            System.out.println("Is Student? " + ob2.isStudent);
            System.out.println("Grade: " + ob2.grade);


        }
}