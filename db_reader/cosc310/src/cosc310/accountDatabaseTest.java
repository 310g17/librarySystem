package cosc310;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class accountDatabaseTest {

	public static void main(String[] args) {
		String filename = "/Users/henryaugustiano/Documents/GitHub/librarySystem/Databases/userDB.csv";
		ArrayList<accountDatabase> accounts = new ArrayList<>(5);
		Path pathToFile = Paths.get(filename);
		
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) 
		{ 
			String line = br.readLine(); 
			while (line != null) { 
				String[] attributes = line.split(",");
				accountDatabase account = createAccount(attributes); 
				accounts.add(account); 
				line = br.readLine(); } 
			} 
		catch (IOException ioe) { 
			ioe.printStackTrace(); 
			}
		}

	private static accountDatabase createAccount(String[] metadata) { 
		int uid = Integer.parseInt(metadata[0]); 
		String uname = metadata[1];
		String pwd = metadata[2]; 
		int lvl = Integer.parseInt(metadata[3]);
		return new accountDatabase(uid, uname, pwd,lvl); 
		}
}


