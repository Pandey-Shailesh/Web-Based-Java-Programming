package org.fi.fullaplication.services;

import org.fi.fullaplication.dto.UsersDTO;
import org.fi.fullaplication.entity.Users;
import org.fi.fullaplication.repository.UsersRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	UsersRepository usersRepository;
	
	
	@Autowired
	MailService mailService;

	@Override
	public boolean addUser(UsersDTO dto) {
		Users objUser = new Users();
		BeanUtils.copyProperties(dto, objUser);
		if (usersRepository.save(objUser)!=null) {
			String contents ="<html><body><h3>Your account has been created with the username:"+objUser.getUserName()+"<h3>"
			
			
			
			
			
			
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public boolean authenticate(String userName, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changePassword(String userName, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
