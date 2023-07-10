package org.fi.fullaplication.controllers;

import org.fi.fullaplication.dto.UsersDTO;
import org.fi.fullaplication.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
@Autowired
UsersService userService;


@PostMapping("/newuser")
public boolean addUser(@RequestBody UsersDTO  userDTO )
{
	return userService.addUser(userDTO);
}
@PostMapping("/changePassword")
public boolean changePassword(@RequestParam String userName, @RequestParam String password)
{
	return userService.changePassword(userName, password);
}

@GetMapping("/authenticate")
public boolean authenticateUaser(@RequestParam String userName, @RequestParam String password)
{
	return userService.authenticate(userName, password);
}













}
