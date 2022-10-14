import java.util.*;
abstract class Account_abstract {//both user and admin can use further extend database
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
    }public String returnBook(String bookName) {
        //add book to account profile
        //reduce number of books available
        return bookName + " has been returned";
    }
}
