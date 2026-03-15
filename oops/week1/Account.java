package week1;

public class Account{
    private String ownerName;
    private double balance;
    public Account(){
        ownerName = "unknown";
        balance = 0.0;
    }
    public void add(double amt){
        balance = balance + amt;
    }
    public void deduct(double amt){
        balance = balance - amt;
    }
    public double getCurrentBalance(){
        return balance;
    }
    public void setOwnerName(String name){
        ownerName = name;
    }
    public String getOwnerName(){
        return ownerName;
    }
    public void setInitialAmount(double amt){
        balance = amt;
    }

}