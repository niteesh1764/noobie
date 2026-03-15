package week1;

public class LibraryCard{

    private NewStudent owner;
    private int copiesBorrowed;

    public LibraryCard(){
        owner = null;
        copiesBorrowed = 0;
    }
    public String getOwner(){
        return owner.getName();
    }
    public void setOwner(NewStudent owner){
        this.owner = owner;
    }
    public void checkOut(int numOfBooks){
        copiesBorrowed = copiesBorrowed + numOfBooks;
    }
    public int getNumOfBooks(){
        return copiesBorrowed;
    }
    public String toString() {
        return "Owner Name: " + owner.getName( ) + "\n" + " Email: " + owner.getEmail( ) + "\n" + "Books Borrowed: " + copiesBorrowed;
    }
}