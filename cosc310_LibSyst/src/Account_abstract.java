import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.*;

import static java.time.temporal.ChronoUnit.DAYS;

abstract class Account_abstract {//both user and admin can use furhter extend database
    protected int UID;
    protected String name; //username
    protected String password;
    protected String[] borrowedBooks; //[[Bookname],[bookname2]]
    protected int access;
    LocalDate[] dateBor;//[[dateBorrowed1], [dateBorrowed2]]
    private static Scanner x;

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
        if (access == 0) {
            return "Library Admin{" +
                    "UID=" + UID +
                    ", name='" + name + '\'' +
                    ", borrowedBooks=" + Arrays.toString(borrowedBooks) +
                    ", dateBorrowed=" + Arrays.toString(dateBor) +
                    ", access=" + access +
                    '}';
        } else {
            return "User{" +
                    "UID=" + UID +
                    ", name='" + name + '\'' +
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
        this.access = access;
    }
    protected double borrowDateTrack(String bookname) {
        int index = dateBookMatch(this.borrowedBooks, bookname);
        try {
            LocalDate dateBorrowed = dateBor[index]; //date borrowing book
            LocalDate date = LocalDate.now(); //current date
            long durationA = DAYS.between(dateBorrowed, date);
            if (durationA > 14) {
                return durationA;
            } else {
                return 0;
            }
        } catch (Exception e) {
            System.out.println("");
        }
        return -1;
    }
    public String borrowBook(String bookName) {
        String book1 = borrowedBooks[0];
        String book2 = borrowedBooks[1];
        double date1 = borrowDateTrack(borrowedBooks[0]);
        double date2 = borrowDateTrack(borrowedBooks[1]);
        if(borrowedBooks[0].equals(null) || borrowedBooks[0].equals("") && date1 <= 0 && date2 <= 0){
                  this.borrowedBooks[0] = bookName;
                  this.dateBor[0] = LocalDate.now();
                  return bookName + " has been borrowed.";
               } else if (borrowedBooks[1].equals(null) || borrowedBooks[1].equals("") && date1 <= 0 && date2 <= 0) {
            this.borrowedBooks[1] = bookName;
            this.dateBor[1] = LocalDate.now();
            return bookName + " has been borrowed.";
        }else {
            System.out.println("You cannot borrow a book as you have two books borrowed or you haven't returned a book");
            return bookName + " has failed to be borrowed.";
        }
    }

    //NEED TO UPDATE CSV FILE UPON COMPLETION OF METHOD update book qty, update borrow status of user
    public String returnBook(String bookName) {
        //return book
        double fees = payLateFees(bookName);
        bookReturn(bookName);
        if (fees > 0) {
            return bookName + " has been returned. Late fees: $" + fees;
        } else if (fees < 0) {
            return "";
        } else {
            return bookName + " has been returned. Late fees: $0";
        }
    }

    protected void bookReturn(String bookName) {
        try {
            int i = dateBookMatch(borrowedBooks, bookName);
            this.borrowedBooks[i] = null; //remove book
            this.dateBor[i] = null;
        } catch (Exception e) {
            System.out.println("Cannot find book in your borrowed list");
        }
    }

    protected double payLateFees(String bookname) {
        double payAmt = dateTracking(bookname) * 2;
        return payAmt;
    }

    protected double dateTracking(String bookname) {
        int index = dateBookMatch(this.borrowedBooks, bookname);
        try {
            LocalDate dateBorrowed = dateBor[index]; //date borrowing book
            LocalDate date = LocalDate.now(); //current date
            long durationA = DAYS.between(dateBorrowed, date);
            System.out.println("Days between return and borrowed: " + durationA +"\n" +
                    "Date borrowed: " + dateBorrowed +"\n" +
                    "Current date: " + date);
            if (durationA > 14) {
                return durationA;
            } else {
                return 0;
            }
        } catch (Exception e) {
            System.out.println("Incorrect book name");
        }
        return -1;
    }

    protected int dateBookMatch(String[] borrowedBooks, String bookTitle) { //how to get the index of each book and dateBor
        for (int i = 0; i < borrowedBooks.length; i++) {
            if (borrowedBooks[i].equals(bookTitle)) {
                return i;
            }
        }
        return -1;
    }

     public static String addAccount(int uid, String uname, String pwd, int lvl){
    	try {
            File dir = new File(".");
    		String loc = "/Users/kevinmario/Documents/Year 3 - Winter Term 1/COSC 310/userDB.csv";
    		FileWriter fstream = new FileWriter(loc, true);
    		BufferedWriter out = new BufferedWriter(fstream);
    		out.write("\n"+uid+","+uname+","+pwd+","+lvl+",NULL,NULL,NULL,NULL");
    		out.close();
            } catch (IOException e) {
            	System.out.println("IOException");
            }
    	return "Account has been added to the system";
    }
    
    public static void updateAccountDB(accountDatabase a) {
		String tempFile = "temp.csv";
    	String loc = "/Users/kevinmario/Documents/Year 3 - Winter Term 1/COSC 310/userDB.csv"; //change path to your own path
    	File newFile = new File (tempFile);
    	File oldFile = new File (loc);
    	String uid="", uname="", pwd="", lvl="", book1="", book2="", date1="", date2="";

        try {
        	FileWriter fw = new FileWriter(tempFile, true);
        	BufferedWriter bw = new BufferedWriter(fw);
        	PrintWriter pw = new PrintWriter(bw);
        	x = new Scanner(new File(loc));
        	x.useDelimiter("[,\n]");
        	
        	while(x.hasNext()) {
        		uid = x.next();
        		uname = x.next();
        		pwd = x.next();
        		lvl = x.next();
        		book1 = x.next();
        		book2 = x.next();
        		date1 = x.next();
        		date2 = x.next();
        		
        		if(uid.equals(Integer.toString(a.getUid()))) {
        			pw.println(a.getUid()+","+a.getUname()+","+a.getPwd()+","+a.getLvl()+","+a.getBook1()+","+a.getBook2()+","+a.getDate1()+","+ a.getDate2());
        		}
        		else {
        			pw.println(uid + "," + uname + "," + pwd + "," + lvl + "," + book1 + "," + book2 + "," + date1 + "," + date2);
        		}
        	}
        	x.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(loc);
            newFile.renameTo(dump);
        } catch(IOException e) {
        	System.out.println("Exception");
        }
    }
    
    public static String addBook(int ISBN, String name, String author, String date, String genre, int qty, boolean borrowed) {
    	try {
            String bor;
    		File dir = new File(".");
    		String loc = "/Users/kevinmario/Documents/Year 3 - Winter Term 1/COSC 310/bookDB.csv";
    		FileWriter fstream = new FileWriter(loc, true);
    		BufferedWriter out = new BufferedWriter(fstream);
    		if(borrowed==false)
    			bor = "F";
    		else
    			bor = "T";
    		out.write("\n"+ISBN+","+name+","+author+","+date+","+genre+","+qty+","+bor);
    		out.close();
            } catch (IOException e) {
            	System.out.println("IOException");
            }
    	return "Book has been added to the system";
    }
    
    public static void removeBook(int ISBN) {
    	String tempFile = "temp.csv";
    	String loc = "/Users/kevinmario/Documents/Year 3 - Winter Term 1/COSC 310/bookDB.csv"; //change path to your own path
    	File newFile = new File (tempFile);
    	File oldFile = new File (loc);
    	String isbn="", name="", author="", date="", genre="", qty="", bor="";

        try {
        	FileWriter fw = new FileWriter(tempFile, true);
        	BufferedWriter bw = new BufferedWriter(fw);
        	PrintWriter pw = new PrintWriter(bw);
        	x = new Scanner(new File(loc));
        	x.useDelimiter("[,\n]");
        	
        	while(x.hasNext()) {
        		isbn = x.next();
        		name = x.next();
        		author = x.next();
        		date = x.next();
        		genre = x.next();
        		qty = x.next();
        		bor = x.next();
        		
        		if(isbn.equals(Integer.toString(ISBN))) {}
        		else {
        			pw.println(isbn + "," + name + "," + author + "," + date + "," + genre + "," + qty + "," + bor);
        		}
        	}
        	x.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(loc);
            newFile.renameTo(dump);
        } catch(IOException e) {
        	System.out.println("Exception");
        }
    }
    
    public static void updateBookDB(book b) {
		String tempFile = "temp.csv";
    	String loc = "/Users/kevinmario/Documents/Year 3 - Winter Term 1/COSC 310/bookDB.csv"; //change path to your own path
    	File newFile = new File (tempFile);
    	File oldFile = new File (loc);
    	String isbn="", name="", author="", date="", genre="", qty="", borrowed="", Sbor="";

        try {
        	FileWriter fw = new FileWriter(tempFile, true);
        	BufferedWriter bw = new BufferedWriter(fw);
        	PrintWriter pw = new PrintWriter(bw);
        	x = new Scanner(new File(loc));
        	x.useDelimiter("[,\n]");
        	
        	if(b.getBorrowed() == false)
        		Sbor = "F";
        	else
        		Sbor = "T";
        	
        	while(x.hasNext()) {
        		isbn = x.next();
        		name = x.next();
        		author = x.next();
        		date = x.next();
        		genre = x.next();
        		qty = x.next();
        		borrowed = x.next();
        		
        		if(isbn.equals(Integer.toString(b.getISBN()))) {
        			pw.println(b.getISBN()+","+b.getName()+","+b.getAuthor()+","+b.getYear()+","+b.getGenre()+","+b.getQty()+","+Sbor);
        		}
        		else {
        			pw.println(isbn + "," + name + "," + author + "," + date + "," + genre +"," + qty + "," + borrowed);
        		}
        	}
        	x.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(loc);
            newFile.renameTo(dump);
        } catch(IOException e) {
        	System.out.println("Exception");
        }
    }
    
}
