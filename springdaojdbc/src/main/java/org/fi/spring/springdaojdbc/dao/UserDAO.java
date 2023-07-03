package org.fi.spring.springdaojdbc.dao;

import java.util.Iterator;

import org.fi.spring.springdaojdbc.entity.Users;

public interface UserDAO {

	
	public boolean addUser(Users objUser);
	public boolean authenticate(String userName,String password);
	public Iterator<Users> allUsers();
}
