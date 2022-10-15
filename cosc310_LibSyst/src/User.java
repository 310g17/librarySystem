import java.time.LocalDate;
import java.util.*;

public class User extends Account_abstract{
    public User(int UID, String name, String password, String[] borrowedBooks, LocalDate[] dateBor) {
        super(UID, name, password, borrowedBooks, 1, dateBor);
    }
    public String addBook(String book){
        return book + "has been added to the system";
    }
    public String removeBook(String book){
        return book + "has been removed to the system";
    }

}