package bean;

import java.util.HashSet;
import java.util.Set;


public class User implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private int userId;
	
	private String userName;
	
	private String password;
	
	private int gender;
	
	private Set<Demo> demos = new HashSet<Demo>();


	public Set<Demo> getDemos() {
		return demos;
	}

	public void setDemos(Set<Demo> demos) {
		this.demos = demos;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}
	

}
