package week1;

public class NewStudent{
    private String name;
    private String email;

    public NewStudent(){
        name = "unknown";
        email = "unknown";
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }

}