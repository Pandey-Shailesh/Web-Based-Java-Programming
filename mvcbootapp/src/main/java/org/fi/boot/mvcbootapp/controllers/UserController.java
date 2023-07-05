package org.fi.boot.mvcbootapp.controllers;

import org.fi.boot.mvcbootapp.beans.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@RequestMapping("/login")
	public void proocessLogin(Model data) {
		data.addAttribute("objUser", new Users());
	}

	@RequestMapping("/authenticate")
	public String proocessAuthenticate(@ModelAttribute("objUSer")Users objUser ) {
		if (objUser.getUserName().equals("shailesh") && objUser.getPassword().equals("Shailesh@123")) {
			return "category";
		} else {
			return "failure";
		}
	}
}
