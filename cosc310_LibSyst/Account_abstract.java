import java.util.scanner;
abstract class Account_abstract {//both user and admin can use
    String name;
    int UID;
    String password;
    int borrowedAmt;
    String[] borrowedBooks; //array within array [str, date] i[0]
    boolean login = false; //determines access to other methods
    Scanner myObj = new Scanner(System.in);
}public void login(int UID, String password){
    //compare with db
    while(login == false){
        if(UID == this.UID && password == this.password){

    }
    }
}public void borrowBook(){

}public void returnBook(){

}public void dateTracking(){

}public void newAccount(){//push to db
    myObj.
}