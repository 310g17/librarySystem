import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.*;
public class main  {
    public static void main(String[] args) {
        //pull data from database class
        String[] borrowedBooks = {"ABC", "BEF"};
        String name = "ABC";
        int uid = 123456;
        String password = "aBc223";
        LocalDate[] dateBor = { LocalDate.parse("2022-05-03", DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                LocalDate.parse("2022-10-13", DateTimeFormatter.ofPattern("yyyy-MM-dd"))};
        //log in will set the variables and what they can do
        //UID, name, password, borrowedBooks, 0, dateBor
        Admin adminNew = new Admin(uid, name, password, borrowedBooks, dateBor);
        System.out.println(adminNew.toString());
        System.out.println(adminNew.returnBook("ABC"));
    }
//}public void login(int UID, String password){ //login information
//    //compare with db
//    while(login == false){
//        if(currentUid == this.UID && currentPw == this.password){
//            login = true;
//            break;
//        }
}
