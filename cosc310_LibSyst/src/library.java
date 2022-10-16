import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class library {

    ArrayList<book> books=new ArrayList<>();
    //int count=books.size();

    public void addDB(String path) throws FileNotFoundException {

        try(
                Scanner sc = new Scanner(new File(path));) {


            String str = sc.nextLine(); // skipping the header
            String[] attributes;



            while(sc.hasNextLine()){

                str=sc.nextLine();//gets the first row
                attributes=str.split(",");
                int isbn=Integer.parseInt(attributes[0]);
                int year =Integer.parseInt(attributes[3]);
                int uid =Integer.parseInt(attributes[5]);
                int qty = Integer.parseInt(attributes[6]);
                boolean borrowed=false;
                if (attributes[7].equals("T")){
                    borrowed=true;}
                else if (attributes[7].equals("F")){
                    borrowed=false;
                }
                books.add(new book(isbn,attributes[1],attributes[2],year,attributes[4],uid,qty,borrowed));


            }


        } catch (IOException ioe) {
            System.out.println("IO exception occurred");
            ioe.printStackTrace();
        }
    }
    public void addBook(int ISBN,String name, String author, int year, String genre, int UID, int qty, boolean borrowed,String path){
        books.add(new book(ISBN,name,author,year,genre,UID,qty,borrowed));
        //adding to book to the csv file ....

    }
    public void removeBook(int ISBN){
        books.remove(findIndex(ISBN));
        //change csv ...
    }
    public void returnBook(int ISBN){

        books.get(findIndex(ISBN)).setBorrowed(false);
        books.get(findIndex(ISBN)).setUID(0);

        //change csv ...


    }
    public void borrowBook(int ISBN,int UID){
        books.get(findIndex(ISBN)).setBorrowed(true);
        books.get(findIndex(ISBN)).setUID(UID);
        //change csv ...

    }
    private int findIndex(int ISBN){
        ListIterator<book> iterator = books.listIterator();
        int index=-1;
        while(iterator.hasNext()){
            if (iterator.next().getISBN()==ISBN){
                index=iterator.nextIndex()-1;
            }
        }
        return index;
    }

    @Override
    public String toString() {
        return "library{" +
                "books=" + books.toString() +
                '}';
    }
}
