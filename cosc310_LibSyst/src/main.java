import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.*;
public class main  {
    public static void main(String[] args) throws Exception {
        //pull data from database class
        String[] borrowedBooks = {"ABC", "BEF"};
        String name = "ABC";
        int uid = 123456;
        String password = "aBc223";
        LocalDate[] dateBor = { LocalDate.parse("2022-09-03", DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                LocalDate.parse("2022-09-29", DateTimeFormatter.ofPattern("yyyy-MM-dd"))};
        //log in will set the variables and what they can do
        //UID, name, password, borrowedBooks, 0, dateBor
        Admin adminNew = new Admin(uid, name, password, borrowedBooks, dateBor);
        System.out.println(adminNew.toString());
        System.out.println(adminNew.toString());
            //File resource = new File(root, "filename.ext");
        ArrayList<accountDatabase>  DBData = accountDatabase.readDB("C:\\Users\\ardik\\OneDrive\\Desktop\\userDB_String.csv");
        System.out.println(DBData.toString());
    }
//}public void login(int UID, String password){ //login information
//    //compare with db
//    while(login == false){
//        if(currentUid == this.UID && currentPw == this.password){
//            login = true;
//            break;
//        }
}
