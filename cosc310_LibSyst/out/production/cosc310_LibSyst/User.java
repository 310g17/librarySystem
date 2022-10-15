import java.util.*;

public class User extends Account_abstract{
    public Admin(String name, int uid, String password, List<String> borrowedBooks) {
        super(name, uid, password, borrowedBooks, 1);
    }
    public String addBook(String book){
        return book + "has been added to the system";
    }
    public String removeBook(String book){
        return book + "has been removed to the system";
    }

}
