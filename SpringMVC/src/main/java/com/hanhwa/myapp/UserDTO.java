package com.hanhwa.myapp;

public class UserDTO {
	// field
	int userid;
	String username;
	
	// get set
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	//toString
	@Override
	public String toString() {
		return "UserDTO [userid=" + userid + ", username=" + username + "]";
	}
	
	
	
	
	

}
