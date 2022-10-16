import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class testBook {
    public static void main(String[] args) throws FileNotFoundException {

        library l1 =new library();
        l1.addDB("bookDB.csv");
        System.out.println(l1.books.toString());
        l1.addBook(11188,"nhchu","hbeerh",1200,"hsjs",0,1,false,"hdier");
        System.out.println(l1.books.toString());
        l1.borrowBook(11188,198);
        System.out.println(l1.books.toString());
        l1.returnBook(11188);
        System.out.println(l1.books.toString());
        l1.removeBook(11188);
        System.out.println(l1.books.toString());





    }
}
