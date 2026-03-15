package week1;

public class SecondMain{
    public static void main(String[] args){
        Bike bike = new Bike();
        Account acc = new Account();
        String myName = "Niteesh";
        bike.setOwner(myName);
        System.out.println("Bike Owner: " + bike.getOwner());
        acc.setOwnerName(myName);
        System.out.println("Account Owner: " + acc.getOwnerName());
        acc.setInitialAmount(5.0);
        System.out.println("Initial balance: " + acc.getCurrentBalance());
        acc.add(10.0);
        System.out.println("Adding balance: " + acc.getCurrentBalance());
        acc.deduct(5.0);
        System.out.println("Deducting balance: " + acc.getCurrentBalance());
    }

}