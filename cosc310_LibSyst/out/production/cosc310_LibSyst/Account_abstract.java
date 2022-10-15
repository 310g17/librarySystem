import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.time.temporal.ChronoUnit.DAYS;

abstract class Account_abstract {//both user and admin can use furhter extend database
    protected int UID;
    protected String name; //username
    protected String password;
    protected String[] borrowedBooks; //[[Bookname],[bookname2]]
    protected int access;
    LocalDate[] dateBor;//[[dateBorrowed1], [dateBorrowed2]]

    public Account_abstract(int UID, String name, String password, String[] borrowedBooks, int access, LocalDate[] dateBor) {
        this.UID = UID;
        this.name = name;
        this.password = password;
        this.borrowedBooks = borrowedBooks;
        this.access = access;
        this.dateBor = dateBor;
    }
    public Account_abstract() {
        this.UID = -1;
        this.name = null;
        this.password = null;
        this.borrowedBooks = null;
        this.access = -1;
        this.dateBor = null;
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
                ", borrowedBooks=" + Arrays.toString(borrowedBooks) +
                ", dateBorrowed=" + Arrays.toString(dateBor) +
                ", access=" + access +
                '}';
       }else{
           return "User{" +
                   "UID=" + UID +
                   ", name='" + name + '\'' +
                   ", password='" + password + '\'' +
                   ", borrowedBooks=" + Arrays.toString(borrowedBooks) +
                   ", dateBorrowed=" + Arrays.toString(dateBor) +
                   ", access=" + access +
                   '}';
       }
    }
    

    public String[] getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(String[] borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public int getAccess() {
        return access;
    }

    public void setAccess(int access) {
        access = access;
    }
    public String borrowBook(String bookName){
        //add book to account profile
        //reduce number of books available
        return bookName + " has been borrowed.";
    }
    //NEED TO UPDATE CSV FILE UPON COMPLETION OF METHOD
    public String returnBook(String bookName){
        //return book
        double fees = payLateFees(bookName);
        bookReturn(bookName);
        if(fees > 0){
            return bookName + " has been returned. Late fees: " + fees;
        } else if (fees < 0) {
            return "";
        } else{
            return bookName + " has been returned. Late fees: 0";
        }
    }
    private void bookReturn(String bookName){
        try{
            int i = dateBookMatch(borrowedBooks, bookName);
            this.borrowedBooks[i] = null; //remove book
            this.dateBor[i] = null;
            }
        catch (Exception e){
            System.out.println("Cannot find book in your borrowed list");
        }
    }
    private double payLateFees(String bookname) {
        double payAmt = dateTracking(bookname)*2;
        return payAmt;
    }

    private double dateTracking(String bookname){
        int index = dateBookMatch(this.borrowedBooks, bookname);
        try{
        LocalDate dateBorrowed = dateBor[index]; //date borrowing book
            LocalDate date = LocalDate.now(); //current date
            long durationA = DAYS.between(dateBorrowed, date);
            System.out.println("Days between return and borrowed: " + durationA);
            if(durationA > 14){
                return durationA;
            }else{
                return 0;}
            }
        catch(Exception e){
            System.out.println("Incorrect book name");}
        return -1;
    }
    private int dateBookMatch(String[] borrowedBooks, String bookTitle){ //how to get the index of each book and dateBor
        for(int i = 0; i < borrowedBooks.length; i++){
            if(borrowedBooks[i].equals(bookTitle)){
                return i;
            }
        }
        return -1;
    }
}
