package firstwebmvn.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	@RequestMapping("/welcome")
	public ModelAndView processWelcome() {
		return new ModelAndView("welcome", "message", "Welcome Coders to the Online Shopping Sides");
	}
}
