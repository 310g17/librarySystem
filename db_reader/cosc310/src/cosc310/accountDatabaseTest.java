package cosc310;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class accountDatabaseTest {

	public static void main(String[] args) {
		String filename = "/Users/henryaugustiano/Documents/GitHub/librarySystem/Databases/userDB.csv";
		ArrayList<accountDatabase> accounts = new ArrayList<>(10);
		Path pathToFile = Paths.get(filename);
		
		try (BufferedReader br = Files.newBufferedReader(pathToFile)) 
		{ 
			String line = br.readLine(); 
			line = br.readLine(); //to skip the file header
			while (line != null) { 
				String[] attributes = line.split(",");
				int uid = Integer.parseInt(attributes[0]);
				int lvl = Integer.parseInt(attributes[3]);
				accountDatabase account = new accountDatabase(uid,attributes[1],attributes[2],lvl) ; 
				accounts.add(account); 
				line = br.readLine(); 
				} 
			} 
		catch (IOException ioe) { 
			System.out.println("IO exception occured");
			ioe.printStackTrace(); 
			}
		
		//testing 
		for (accountDatabase acc : accounts) {
			System.out.println(acc);
			}
	}


}


