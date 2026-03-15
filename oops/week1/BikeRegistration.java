package week1;
import java.util.*;
public class BikeRegistration{

    public static void main(String[] args){
        Bike bike1 , bike2;
        String owner1 , owner2;
        Scanner sc = new Scanner(System.in);
        bike1 = new Bike();
        bike2 = new Bike();
        owner1 = sc.next();
        owner2 = sc.next();
        bike1.setOwner(owner1);
        bike2.setOwner(owner2);
        sc.close();
        System.out.println(bike1.getOwner() + " owns a bike");
        System.out.println(bike2.getOwner() + " also owns a bike");

    }
}