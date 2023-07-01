package org.fi.spring.thirdspringapps.beans;

import org.springframework.stereotype.Component;

@Component("objUser")
public class Users {

	public Users () {
		
	}
	public Users(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	String userName;
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
	String password;
}
