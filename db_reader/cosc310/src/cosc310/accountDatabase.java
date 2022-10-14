package cosc310;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class accountDatabase {
	//attributes
	private int uid;
	private String uname;
	private String pwd; 
	private int lvl;
	
	//constructor
	public accountDatabase(int uid, String uname, String pwd, int lvl){
		this.uid = uid;
		this.uname = uname;
		this.pwd = pwd;
		this.lvl = lvl; 
	}
	
	

	@Override
	public String toString() {
		return "accountDatabase [uid=" + uid + ", uname=" + uname + ", pwd=" + pwd + ", lvl=" + lvl + "]";
	}
	
	public void readDB(String path) {
		String filename = path;
		ArrayList<accountDatabase> accounts = new ArrayList<>();
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



	
	
	
}
