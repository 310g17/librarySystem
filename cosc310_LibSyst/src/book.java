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
    int qty;
    boolean borrowed;
    int originalAmt;



    book(){
    	this.ISBN = 0;
    	this.name = null;
    	this.author = null;
    	this.year = 0;
    	this.genre = null;
    	this.qty = 0;
    	this.borrowed = false;
        this.originalAmt = 0;
    }

    book(int ISBN,String name, String author, int year, String genre, int qty,boolean borrowed, int originalAmt){
        setAuthor(author);
        setGenre(genre);
        setISBN(ISBN);
        setName(name);
        setQty(qty);
        setYear(year);
        setBorrowed(borrowed);
        this.originalAmt = originalAmt;
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
    public int getQty() {
        return qty;
    }
    public String getGenre() {
        return genre;
    }
    public boolean getBorrowed() {
        return borrowed;
    }public int getOriginalAmt(){
        return this.originalAmt;
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

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

     public void setOriginalAmount(int originalAmt) {
    	this.originalAmt = originalAmt;
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
                ", qty=" + qty + '\''+
                ", borrowed=" + borrowed+
                ", originalAmt= "+this.originalAmt+
                '}';
    }

    
}