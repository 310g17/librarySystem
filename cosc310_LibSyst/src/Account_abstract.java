import java.util.*;
abstract class Account_abstract {//both user and admin can use furhter extend database
    protected int UID;
    protected String name;
    protected String password;
    protected List<String> borrowedBooks;
    protected int access;
    Account_abstract(String name, int uid, String password, List<String> borrowedBooks, int access){
        this.name = name;
        this.UID = uid;
        this.password = password;
        this.borrowedBooks = borrowedBooks;
        this.access = access;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
       if(access == 0){
        return "Library Admin{" +
                "UID=" + UID +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                ", access=" + access +
                '}';
       }else{
           return "User{" +
                   "UID=" + UID +
                   ", name='" + name + '\'' +
                   ", password='" + password + '\'' +
                   ", borrowedBooks=" + borrowedBooks +
                   ", access=" + access +
                   '}';
       }
    }

    public List<String> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<String> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public int getAccess() {
        return access;
    }

    public void setAccess(int access) {
        access = access;
    }public String borrowBook(String bookName){
        //add book to account profile
        //reduce number of books available
        return bookName + " has been borrowed";
    }
    //    String name;
//    private int[] UIDarray;
//    private String[] password; //ONLY USED HERE
//    int borrowedAmt;
//    String[] borrowedBooks; //array within array [str, date] i[0]
//    public boolean login = false; //determines access to other methods
//    private Scanner myObj = new Scanner(System.in);
//    int currentUid;
//    private String currentPw;
//    int access;
//}public void login(int UID, String password){ //login information
//    //compare with db
//    while(login == false){
//        if(currentUid == this.UID && currentPw == this.password){
//            login = true;
//            break;
//    }
//    }
//}public void borrowBook(){
//
//}public void returnBook(){
//
//}public void dateTracking(){
//
//}public void newAccount(){//push to db
//    boolean done = false;
//    while(done == false) {
//        System.out.println("Enter your uid (6 integers): ");
//        try{
//        int userName = myObj.nextLine();
//        done = uidExists(userName);
//        if(done == true){
//            System.out.println("Enter your password (a combination of letters and strings: ");
//            String password = myObj.nextLine();
//            break;
//        }}catch(Exception e){
//            System.out.println("Incorrect input, please try again");
//        }
//    }
//    ////// add new userid and pw to db
//
//}
//private boolean uidExists(userName){ // checks availability of username
//    boolean checkIf = true;
//    for(int i = 0; i < (UIDarray.length-1); i++){
//        if(userName == UIDarray[i]){
//            checkIf == false;
//            break;
//        }
//    }
//    return checkIf;
//}private String filter(){
//    //use book filtering system
}
