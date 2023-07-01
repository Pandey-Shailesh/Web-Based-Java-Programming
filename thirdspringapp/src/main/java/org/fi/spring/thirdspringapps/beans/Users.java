package org.fi.spring.thirdspringapps.beans;

import org.springframework.stereotype.Component;

@Component("objUser")
public class Users {

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
