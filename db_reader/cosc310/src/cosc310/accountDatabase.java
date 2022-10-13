package cosc310;

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
