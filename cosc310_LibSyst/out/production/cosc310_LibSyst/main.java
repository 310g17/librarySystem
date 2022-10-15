import java.time.LocalDate;
import java.util.*;
public class main {
    public static void main(String[] args) throws Exception {
        //pull data from database class
        ArrayList<accountDatabase> DBData = accountDatabase.readDB("C:\\Users\\ardik\\OneDrive\\Desktop\\userDB_String.csv");
        //Ask what user wants to do
        //upon creating a new account make new and then end the program
        Scanner in = new Scanner(System.in); //use .equals to compare strings
        System.out.print("What would you like to do? Login (type login) or create a new account (type create): ");
        String decision = in.nextLine();
        if(decision.equals("create")){
            //add create an account method

            return;
        }else if(decision.equals("login")){

        }else{
            System.out.println("That is not a valid input, terminating");
        }
        boolean useB = false;
        String username = "";
        int index = -1;
        System.out.print("Hello, please input your username: ");
        while (useB == false) {
            username = in.nextLine();
            if (uMatching(DBData, username) == username){
                index = setIndex(DBData, username);
                break;
            }else{
                System.out.println("That is not a valid username. Please enter a valid username: ");
            };
        }
        System.out.print("please input you password: ");
        while (useB == false) {
            String password = in.nextLine();
            if (pMatching(DBData, password, index) == password){
                System.out.println("Login successful. Welcome " + username + ".");
                break;
            }else{
                System.out.println("That is not a valid password. Please enter the right password: ");
            };
        }
        accountDatabase loggedIn = DBData.get(index);
        int accessLevel = loggedIn.getLvl();
        String[] borrowedBooks = {loggedIn.getBook1(), loggedIn.getBook2()};
        LocalDate[] dateBor = {loggedIn.getDate1(), loggedIn.getDate2()};
        Account_abstract currentUser;
        if(accessLevel == 0){
            currentUser = new Admin(loggedIn.getUid(), loggedIn.getUname(), loggedIn.getPwd(),borrowedBooks, dateBor);
        }else{
            currentUser = new User(loggedIn.getUid(), loggedIn.getUname(), loggedIn.getPwd(),borrowedBooks, dateBor);
        }
        System.out.println(currentUser.toString());
    }
    public static int setIndex(ArrayList<accountDatabase> DBData, String username){
        int result = -1;
        for (int i = 0; i < DBData.size(); i++) {
            accountDatabase x = DBData.get(i);
            result++;
            if (x.getUname().equals(username)) {
                //changes index so that the current index stays on the proper username index
                return result;
        }}
        return -1;
    }
    public static String uMatching(ArrayList<accountDatabase> DBData, String username) {
        for (int i = 0; i < DBData.size(); i++) {
            accountDatabase x = DBData.get(i);
            if (x.getUname().equals(username)) {
                //changes index so that the current index stays on the proper username index
                return username;
            }
        }
            return "";
        }public static String pMatching(ArrayList<accountDatabase> DBData, String password, int index) {
            accountDatabase x = DBData.get(index);
            if (x.getPwd().equals(password)) {

                return password;
            }
        return "";
    }
    }

