import java.util.List;
import java.util.*;
public class main  {
    public static void main(String[] args) {
        //pull data from database class
        List<String> borrowedBooks = new ArrayList<>();
        borrowedBooks.add("Book1");
        borrowedBooks.add("book2");
        String name = "ABC";
        int uid = 123456;
        String password = "aBc223";
        //log in will set the variables and what they can do
        Admin adminNew = new Admin(name, uid, password, borrowedBooks);
        System.out.println(adminNew.toString());
    }
//}public void login(int UID, String password){ //login information
//    //compare with db
//    while(login == false){
//        if(currentUid == this.UID && currentPw == this.password){
//            login = true;
//            break;
//        }
}
