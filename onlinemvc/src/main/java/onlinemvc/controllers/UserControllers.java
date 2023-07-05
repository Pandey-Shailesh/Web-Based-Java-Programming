package onlinemvc.controllers;

import org.fi.spring.springdaojdbc.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import onlinemvc.beans.Users;

@Controller
public class UserControllers {
	
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/login")
	public void prepareLogin(Model data) {
		data.addAttribute("objUser",new Users());
	}
	
	@RequestMapping("/authenticate")
	public String processAuthenticate(@ModelAttribute("objUser") Users objUser) {
		if (userDAO.authenticate(objUser.getUserName(), objUser.getPassword())) {
			session.setAttribute("userName", objUser.getUserName());
			return "forward:category";
		} else {
			return "failure";
		}
	}
}
