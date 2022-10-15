package Step2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class User extends Account_abstract{
<<<<<<< Updated upstream
    public User(int UID, String name, String password, String[] borrowedBooks, LocalDate[] dateBor) {
        super(UID, name, password, borrowedBooks, 1, dateBor);
    }
=======

public User(int UID, String name, String password, String[] borrowedBooks, LocalDate[] dateBor)  {
	 	super(UID, name, password, borrowedBooks, 0, dateBor);
    }
public String newAccount(String book){
	try {
        File dir = new File(".");
		String loc = "/Users/kevinmario/Documents/Year 3 - Winter Term 1/COSC 310/userDB.csv";
 
		FileWriter fstream = new FileWriter(loc, true);
		BufferedWriter out = new BufferedWriter(fstream);
		out.newLine();
		out.write("112235, sam, sam12345, 1, Red Riding Hood, NULL, 2022-08-23, NULL");
		out.close();
        } catch (IOException e) {
        	System.out.println("IOException");
        }
	return "account has been added to the system";
}
>>>>>>> Stashed changes
}


