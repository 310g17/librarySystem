import java.time.LocalDate;
import java.util.*;
public class Admin extends Account_abstract{ //can create objects from class

    public Admin(int UID, String name, String password, String[] borrowedBooks, LocalDate[] dateBor) {
        super(UID, name, password, borrowedBooks, 0, dateBor);
    }

    public String addBook(String book){
        return book + "has been added to the system";
    }
    public String removeBook(String book){
        return book + "has been removed to the system";
    }
}//add add/remove book fn




