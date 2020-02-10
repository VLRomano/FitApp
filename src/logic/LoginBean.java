package logic;

public class LoginBean {
	
	public LoginBean(String usrname, String pword) {
		username = usrname;
		password = pword;
	}
	
	private String password;
	private String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	

}
