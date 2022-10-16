import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class testBook {
    public static void main(String[] args) throws FileNotFoundException {

        library l1 =new library();
        l1.addDB("C:\\Users\\ardik\\OneDrive\\Desktop\\bookDB.csv");
        System.out.println(l1.books.toString());




    }
}
