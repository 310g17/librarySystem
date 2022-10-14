import java.util.*;
public class Admin extends Account_abstract{ //can create objects from class
    public Admin(String name, int uid, String password, List<String> borrowedBooks) {
        super(name, uid, password, borrowedBooks, 0);
    }
    public String addBook(String book){
        return book + "has been added to the system";
    }
    public String removeBook(String book){
        return book + "has been removed to the system";
    }
}//add add/remove book fn


