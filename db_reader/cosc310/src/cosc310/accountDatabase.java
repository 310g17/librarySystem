package cosc310;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.*;


public class accountDatabase {
	//attributes
	private int uid;	  
	private String uname; 
	private String pwd; 
	private int lvl;
	private int book1;
	private int book2;
	private Date date1;
	private Date date2;
	
	
	//constructor
	public accountDatabase(int uid, String uname, String pwd, int lvl, int book1, int book2, Date date1, Date date2){
		this.uid = uid;
		this.uname = uname;
		this.pwd = pwd;
		this.lvl = lvl; 
		this.book1 = book1;
		this.book2 = book2;
		this.date1 = date1;
		this.date2 = date2;
	}
	
	


	public void readDB(String path) throws ParseException {
		String filename = path;
		ArrayList<accountDatabase> accounts = new ArrayList<>();
		Path pathToFile = Paths.get(filename);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH); // cast string to date
		try (BufferedReader br = Files.newBufferedReader(pathToFile)) 
		{ 
			String line = br.readLine(); 
			line = br.readLine(); //to skip the file header
			
			
			while (line != null) { 
				String[] attributes = line.split(",");
				int uid = Integer.parseInt(attributes[0]);
				int lvl = Integer.parseInt(attributes[3]);
				int book1, book2;
				Date date1, date2;
				
				//check if book1 || book2 cell is null
				if(attributes[4].equals("NULL")) 
					book1 = 0;
				else
					book1 = Integer.parseInt(attributes[4]);
					
				if(attributes[5].equals("NULL")) 
					book2 = 0;
				else
					book2 = Integer.parseInt(attributes[5]);
				
				//check if date1 || date2 is null
				if(attributes[6].equals("NULL")) 
					date1 = null;
				else
					date1 = formatter.parse(attributes[6]);
					
				if(attributes[7].equals("NULL")) 
					date2 = null;
				else
					date2 = formatter.parse(attributes[7]);
				
				//create account objects and store to array
				accountDatabase account = new accountDatabase(uid,attributes[1],attributes[2],lvl, book1, book2, date1, date2) ; 
				accounts.add(account); 
				line = br.readLine(); 
				} 
			} 
		catch (IOException ioe) { 
			System.out.println("IO exception occured");
			ioe.printStackTrace(); 
			}
	}
	
	public static void updatepwd(String newpw ) {
		
		
		}




	public int getUid() {
		return uid;
	}




	public void setUid(int uid) {
		this.uid = uid;
	}




	public String getUname() {
		return uname;
	}




	public void setUname(String uname) {
		this.uname = uname;
	}




	public String getPwd() {
		return pwd;
	}




	public void setPwd(String pwd) {
		this.pwd = pwd;
	}




	public int getLvl() {
		return lvl;
	}




	public void setLvl(int lvl) {
		this.lvl = lvl;
	}




	public int getBook1() {
		return book1;
	}




	public void setBook1(int book1) {
		this.book1 = book1;
	}




	public int getBook2() {
		return book2;
	}




	public void setBook2(int book2) {
		this.book2 = book2;
	}




	public Date getDate1() {
		return date1;
	}




	public void setDate1(Date date1) {
		this.date1 = date1;
	}




	public Date getDate2() {
		return date2;
	}




	public void setDate2(Date date2) {
		this.date2 = date2;
	}


	


	
	
	
}
