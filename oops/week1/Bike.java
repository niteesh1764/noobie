package week1;

public class Bike{
    private String owner;

    public Bike(){
        owner = "unknown";
    }
    // public Bike(String name){
    //     owner = name;
    // }
    public String getOwner(){
        return owner;
    }
    public void setOwner(String owner){
        this.owner = owner;
    }

}