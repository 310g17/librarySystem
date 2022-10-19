
import java.time.LocalDate;
import java.util.*;
public class main {
    public static void main(String[] args) throws Exception {
        //pull data from database class
        library l1 =new library();
        l1.addDB("/Users/kevinmario/Documents/Year 3 - Winter Term 1/COSC 310/bookDB.csv");
        ArrayList<accountDatabase> DBData = accountDatabase.readDB("/Users/kevinmario/Documents/Year 3 - Winter Term 1/COSC 310/userDB.csv");
        //Ask what user wants to do
        //upon creating a new account make new and then end the program
        Scanner in = new Scanner(System.in); //use .equals to compare strings
        System.out.print("What would you like to do? Login (type login) or create a new account (type create): ");
        String decision = in.nextLine();
        if(decision.equals("create")){
                //create an account method
                System.out.println("Enter your username:");
                String uname = in.nextLine();
                System.out.println("Enter password:");
                String pwd = in.nextLine();
                System.out.println("Are you admin or user (Enter 0 for admin and 1 for user):");
                int lvl = in.nextInt();
                int uid = (DBData.get(DBData.size()-1).getUid())+1;
                System.out.println(Account_abstract.addAccount(uid, uname, pwd, lvl)); //default value for lvl is 1 (user)

            
            return;
        }else if(decision.equals("login")){

        }else{
            System.out.println("That is not a valid input, terminating");
            return;
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
        System.out.print("please input your password: ");
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
        
        System.out.println("What would you like to do today " + username + "?");
        boolean looper = false;
        while(looper == false){
            showOptions(currentUser.getAccess());
            System.out.println("");
            int Choice = in.nextInt();
            if(DoWhat(Choice, currentUser, l1) == 0){
                looper = true;
            }
        }
        //rewrite final system
        System.out.println("Thank you for using our service");
    }

    private static int DoWhat(int choice, Account_abstract currentUser, library l1) {
        switch(choice) {
            case 0:
                return 0;
            case 1:
                bBook(currentUser, l1);
                System.out.println("This is your current status: " + currentUser.toString());
                break;
            case 2:
                rBook(currentUser, l1);
                System.out.println("This is your current status: " + currentUser.toString());
                break;
            case 3:
                System.out.println(currentUser.toString());
                break;
            case 4:
            	addBook(currentUser, l1);
                break;
            case 5:
            	removeBook(currentUser, l1);
            	break;
            default:
                System.out.println("incorrect input");

        }
        return -1;
        }
    
    private static void addBook(Account_abstract currentUser, library l1){
    	Scanner in = new Scanner(System.in);
    	System.out.println("Enter book's ISBN:");
    	int isbn = in.nextInt();
    	in.nextLine();
    	System.out.println("Enter book's name:");
    	String name = in.nextLine();
    	System.out.println("Enter book's author:");
    	String author = in.nextLine();
    	System.out.println("Enter book's year published:");
    	int year = in.nextInt();
    	in.nextLine();
    	System.out.println("Enter book's genre:");
    	String genre = in.nextLine();
    	System.out.println("Enter quantity of book:");
    	int qty = in.nextInt();
    	int orgAmt = qty;
    	boolean borrowed = false;
    	l1.addBook(isbn, name, author, year, genre, qty, borrowed, orgAmt);
    	if(currentUser.getAccess()==0) {
    		Account_abstract.addBook(isbn, name, author, year, genre, qty, borrowed, orgAmt);
    		System.out.println("Book added to the system");
    	}else
    		System.out.println("If you are not an administrator, you cannot add books from the database");
    }
    
    private static void removeBook(Account_abstract currentUser, library l1){
    	Scanner in = new Scanner(System.in);
    	System.out.println("Enter book's ISBN that you want to remove:");
    	int isbn = in.nextInt();
    	l1.removeBook(isbn);
    	if(currentUser.getAccess()==0) {
    		Account_abstract.removeBook(isbn);
    		System.out.println("Book removed from the system");
    	}else
    		System.out.println("If you are not an administrator, you cannot add books from the database");
    }
    
    private static void bBook(Account_abstract currentUser, library l1){
        Scanner in = new Scanner(System.in);
        System.out.println("These are our selection of books: " ); //SELECTION OF ALL BOOKS AVAILABLE System.out.println(l1.books.get(0));
        for(int i = 0 ; i < l1.books.size(); i++){
            if(l1.books.get(i).getQty() > 0){
                System.out.print(l1.books.get(i).getName() +"\n"); //+ " by "+ l1.books.get(i).getAuthor()
            }
        }
        System.out.println("What is the exact title of the book you want to borrow?");
        String bookName = in.nextLine();
        //reduce the number of qty available
        accountDatabase a = new accountDatabase();
        book b = new book();
        
        for(int i = 0 ; i < l1.books.size(); i++){
            if(l1.books.get(i).getName().equals(bookName)){
               if(l1.books.get(i).getQty() > 0) {
            	int z = l1.books.get(i).getQty();
               l1.books.get(i).setQty(z-1);
               l1.books.get(i).setBorrowed(true);
               b.setISBN(l1.books.get(i).getISBN());
               b.setName(l1.books.get(i).getName());
               b.setAuthor(l1.books.get(i).getAuthor());
               b.setYear(l1.books.get(i).getYear());
               b.setGenre(l1.books.get(i).getGenre());
               b.setQty(l1.books.get(i).getQty());
               b.setBorrowed(l1.books.get(i).getBorrowed());
               b.setOriginalAmount(l1.books.get(i).getOriginalAmt());
               
               if(currentUser.getBorrowedBooks()[0].equals("")) {
            	   a.setUid(currentUser.getUID());
            	   a.setUname(currentUser.getName());
            	   a.setPwd(currentUser.getPassword());
	               a.setLvl(currentUser.getAccess());
	               a.setBook1(bookName);
	               a.setDate1(LocalDate.now());
               } else {
            	   a.setUid(currentUser.getUID());
            	   a.setUname(currentUser.getName());
            	   a.setPwd(currentUser.getPassword());
            	   a.setLvl(currentUser.getAccess());
            	   a.setBook1(currentUser.getBorrowedBooks()[0]);
            	   a.setBook2(bookName);
            	   a.setDate1(currentUser.getDateBor()[0]);
            	   a.setDate2(LocalDate.now());
               } 
               }
            
        }
           
            }
        System.out.println(currentUser.borrowBook(bookName));
        Account_abstract.updateBookDB(b);
        Account_abstract.updateAccountDB(a);
    }
    
    private static void rBook(Account_abstract currentUser, library l1) {
    	accountDatabase a = new accountDatabase();
        book b = new book();
    	Scanner in = new Scanner(System.in);
        System.out.println("These are your current books: " + Arrays.toString(currentUser.getBorrowedBooks()));
        System.out.println("What is the exact title of the book you would like to return?");
        String bookName = in.nextLine();
        
        for(int i = 0 ; i < l1.books.size(); i++){
            if(l1.books.get(i).getName().equals(bookName)){
               int z = l1.books.get(i).getQty();
               l1.books.get(i).setQty(z+1);
               if(l1.books.get(i).getQty() < l1.books.get(i).getOriginalAmt()){
                l1.books.get(i).setBorrowed(true);
                b.setISBN(l1.books.get(i).getISBN());
                b.setName(l1.books.get(i).getName());
                b.setAuthor(l1.books.get(i).getAuthor());
                b.setYear(l1.books.get(i).getYear());
                b.setGenre(l1.books.get(i).getGenre());
                b.setQty(l1.books.get(i).getQty());
                b.setBorrowed(l1.books.get(i).getBorrowed());
                b.setOriginalAmount(l1.books.get(i).getOriginalAmt());
                
                if(currentUser.getBorrowedBooks()[1].equals(bookName)) {
             	   a.setUid(currentUser.getUID());
             	   a.setUname(currentUser.getName());
             	   a.setPwd(currentUser.getPassword());
 	               a.setLvl(currentUser.getAccess());
 	               a.setBook1(currentUser.getBorrowedBooks()[0]);
 	               a.setBook2(null);
 	               a.setDate1(currentUser.getDateBor()[0]);
 	               a.setDate2(null);
                } else if(currentUser.getBorrowedBooks()[0].equals(bookName)&&currentUser.getBorrowedBooks()[1].equals("")){
                   a.setUid(currentUser.getUID());
              	   a.setUname(currentUser.getName());
              	   a.setPwd(currentUser.getPassword());
  	               a.setLvl(currentUser.getAccess());
  	               a.setBook1(null);
  	               a.setDate1(null);
                }else if(currentUser.getBorrowedBooks()[0].equals(bookName)&&!currentUser.getBorrowedBooks()[1].equals("")){
                   a.setUid(currentUser.getUID());
               	   a.setUname(currentUser.getName());
               	   a.setPwd(currentUser.getPassword());
   	               a.setLvl(currentUser.getAccess());
   	               a.setBook1(null);
   	               a.setBook2(currentUser.getBorrowedBooks()[1]);
   	               a.setDate1(null);
   	               a.setDate2(currentUser.getDateBor()[1]);
                }
               }else{
                l1.books.get(i).setBorrowed(false);
                b.setISBN(l1.books.get(i).getISBN());
                b.setName(l1.books.get(i).getName());
                b.setAuthor(l1.books.get(i).getAuthor());
                b.setYear(l1.books.get(i).getYear());
                b.setGenre(l1.books.get(i).getGenre());
                b.setQty(l1.books.get(i).getQty());
                b.setBorrowed(l1.books.get(i).getBorrowed());
                b.setOriginalAmount(l1.books.get(i).getOriginalAmt());
                
                if(currentUser.getBorrowedBooks()[1].equals(bookName)) {
              	   a.setUid(currentUser.getUID());
              	   a.setUname(currentUser.getName());
              	   a.setPwd(currentUser.getPassword());
  	               a.setLvl(currentUser.getAccess());
  	               a.setBook1(currentUser.getBorrowedBooks()[0]);
  	               a.setBook2(null);
  	               a.setDate1(currentUser.getDateBor()[0]);
  	               a.setDate2(null);
                 } else if(currentUser.getBorrowedBooks()[0].equals(bookName)&&currentUser.getBorrowedBooks()[1].equals("")){
                    a.setUid(currentUser.getUID());
               	   a.setUname(currentUser.getName());
               	   a.setPwd(currentUser.getPassword());
   	               a.setLvl(currentUser.getAccess());
   	               a.setBook1(null);
   	               a.setDate1(null);
                 }else if(currentUser.getBorrowedBooks()[0].equals(bookName)&&!currentUser.getBorrowedBooks()[1].equals("")){
                    a.setUid(currentUser.getUID());
                	   a.setUname(currentUser.getName());
                	   a.setPwd(currentUser.getPassword());
    	               a.setLvl(currentUser.getAccess());
    	               a.setBook1(null);
    	               a.setBook2(currentUser.getBorrowedBooks()[1]);
    	               a.setDate1(null);
    	               a.setDate2(currentUser.getDateBor()[1]);
                 }
               }
        }
            
            }
        System.out.println(currentUser.returnBook(bookName));
        Account_abstract.updateBookDB(b);
        Account_abstract.updateAccountDB(a);
        }
        
    

    private static void showOptions(int access) {
        System.out.print("0. Terminate process to save all progress (press 0) \n" +
                "1. Borrow a book (press 1) \n" +
                "2. Return a book (press 2) \n" +
                "3. Check your borrowing status (press 3) \n"
        );
        if(access == 0){
            System.out.println(
                    "4. Add a book to the database (press 4) \n" +
                    		"5. Remove a book from the database (press 5)\n"
            );
        }
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

