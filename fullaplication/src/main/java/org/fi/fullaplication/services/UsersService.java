package org.fi.fullaplication.services;


import org.fi.fullaplication.dto.UsersDTO;

public interface UsersService {
	public boolean addUser(UsersDTO dto );
	public boolean authenticate(String userName , String password );
	public boolean changePassword(String userName , String password );
	
}
