package org.fi.boot.restfullapi.controllers;

import org.fi.boot.restfullapi.dto.Users;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserController {
	
	
		@PostMapping("/authenticate")
		public boolean authenticateUser(@RequestParam("uname")String userName,@RequestParam("pwd")String password) {
			if (userName.equals("Pankaj") && password.equals("Guruji")) {
				return true;
			} else {
				return false;
			}
			
		}
		
		
		@GetMapping("/authenticateGet")
		public boolean authenticateUserGet(@RequestParam("uname")String userName,@RequestParam("pwd")String password) {
			if (userName.equals("Pankaj") && password.equals("Guruji")) {
				return true;
			} else {
				return false;
			}
			
		}
		
		@GetMapping("/getUserDetails")
		public Users getUserDetails() {
			Users objUser = new Users();
			objUser.setUserName("Pankaj");
			objUser.setPassword("Sir");
			objUser.setName("Guruji");
			objUser.setEmail("guruji@sir.com");
			return objUser;
			
		}
		
		
}
