package org.fi.spring.fifthapp.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class Users {

	String userName;
	String password;

	public Users(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public Users() {
		System.out.println("ctor of User");
	}

public void initializeUser() {
	System.out.println("Init of user");
}
	
public void destroy() {
	System.out.println("destroy of user");
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

}
