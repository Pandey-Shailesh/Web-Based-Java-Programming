package onlinemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import onlinemvc.beans.Users;

@Controller
public class UserControllers {
	@RequestMapping("/login")
	public void prepareLogin(Model data) {
		data.addAttribute("objUser",new Users());
	}
	@RequestMapping("/authenticate")
	public ModelAndView processAuthenticate(@ModelAttribute("objUser") Users objUser) {
		if (objUser.getUserName().equals("shailesh") && objUser.getPassword().equals("Shailesh@123")) {
			return new ModelAndView("welcome","message","welcome user "+objUser.getUserName()+" to Online Shopping Application");
		} else {
			return new ModelAndView("failure","message","You have failed to authenticate yourself.");
		}
	}
}
