import java.util.scanner;
abstract class Account_abstract {//both user and admin can use furhter extend database
    String name;
    private int[] UIDarray;
    private String[] password; //ONLY USED HERE
    int borrowedAmt;
    String[] borrowedBooks; //array within array [str, date] i[0]
    public boolean login = false; //determines access to other methods
    private Scanner myObj = new Scanner(System.in);
    int currentUid;
    private String currentPw;
    int access;
}public void login(int UID, String password){ //login information
    //compare with db
    while(login == false){
        if(currentUid == this.UID && currentPw == this.password){
            login = true;
            break;
    }
    }
}public void borrowBook(){

}public void returnBook(){

}public void dateTracking(){

}public void newAccount(){//push to db
    boolean done = false;
    while(done == false) {
        System.out.println("Enter your uid (6 integers): ");
        try{
        int userName = myObj.nextLine();
        done = uidExists(userName);
        if(done == true){
            System.out.println("Enter your password (a combination of letters and strings: ");
            String password = myObj.nextLine();
            break;
        }}catch(Exception e){
            System.out.println("Incorrect input, please try again");
        }
    }
    ////// add new userid and pw to db

}
private boolean uidExists(userName){ // checks availability of username
    boolean checkIf = true;
    for(int i = 0; i < (UIDarray.length-1); i++){
        if(userName == UIDarray[i]){
            checkIf == false;
            break;
        }
    }
    return checkIf;
}private String filter(){
    //use book filtering system
}
