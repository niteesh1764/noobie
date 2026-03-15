package week1;

public class Librarian{

    public static void main(String[] args){
        NewStudent stud = new NewStudent();
        stud.setName("Niteesh");
        stud.setEmail("f20220704@hyderabad.bits-pilani.ac.in");
        LibraryCard card1 = new LibraryCard();
        LibraryCard card2 = new LibraryCard();
        card1.setOwner(stud);
        card2.setOwner(stud);
        card1.checkOut(5);
        card2.checkOut(3);
        System.out.println(card1.toString() + "\n");
        System.out.println(card2.toString() + "\n");
    }
}