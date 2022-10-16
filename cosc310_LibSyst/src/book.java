import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class book {
    int ISBN;
    String name;
    String author;
    int year;
    String genre;
    int UID;
    int qty;
    boolean borrowed;



    book(){

    }

    book(int ISBN,String name, String author, int year, String genre, int UID, int qty,boolean borrowed){
        setAuthor(author);
        setGenre(genre);
        setISBN(ISBN);
        setName(name);
        setQty(qty);
        setUID(UID);
        setYear(year);
        setBorrowed(borrowed);
    }



    //getters
    public String getName() {
        return name;
    }
    public int getYear() {
        return year;
    }
    public int getISBN() {
        return ISBN;
    }
    public String getAuthor() {
        return author;
    }
    public int getUID() {
        return UID;
    }
    public int getQty() {
        return qty;
    }
    public String getGenre() {
        return genre;
    }


    //setters

    public void setName(String name) {
        this.name = name;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }
    public void setUID(int UID) {
        this.UID = UID;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }
    //methods


    @Override
    public String toString() {
        return "book{" +
                "ISBN=" + ISBN +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", UID=" + UID +
                ", qty=" + qty + '\''+
                ", borrowed=" + borrowed+
                '}';
    }
}