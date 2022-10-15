package Step2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

import au.com.bytecode.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class Admin extends Account_abstract{ //can create objects from class
	accountDatabase Adb = new accountDatabase(UID, name, name, UID, UID, UID, null, null);
    public Admin(int UID, String name, String password, String[] borrowedBooks, LocalDate[] dateBor) {
        super(UID, name, password, borrowedBooks, 0, dateBor);
    }

<<<<<<< Updated upstream
    public String addBook(String book){
        return book + "has been added to the system";
    }
    public String removeBook(String book){
        return book + "has been removed from the system";
    }
    
=======
    public String newAccount(String book){
    	try {
            File dir = new File(".");
    		String loc = "/Users/kevinmario/Documents/Year 3 - Winter Term 1/COSC 310/userDB.csv";
     
    		FileWriter fstream = new FileWriter(loc, true);
    		BufferedWriter out = new BufferedWriter(fstream);
    		out.newLine();
    		out.write("112235, sam, sam12345, 0, Red Riding Hood, NULL, 2022-08-23, NULL");
    		out.close();
            } catch (IOException e) {
            	System.out.println("IOException");
            }
    	return "Account has been added to the system";
    }
    
    
>>>>>>> Stashed changes
}//add add/remove book fn


