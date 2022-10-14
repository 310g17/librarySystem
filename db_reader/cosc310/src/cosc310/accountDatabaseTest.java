package cosc310;


import java.text.ParseException;
import java.util.*;

public class accountDatabaseTest extends accountDatabase{

	public static void main(String[] args) throws ParseException {
		 ArrayList<accountDatabase> accounts =accountDatabase.readDB("/Users/henryaugustiano/Documents/GitHub/librarySystem/Databases/userDB.csv");
			
		//testing 
		for (accountDatabase acc : accounts) {
			System.out.println(accounts);
			}
	
	}


}


