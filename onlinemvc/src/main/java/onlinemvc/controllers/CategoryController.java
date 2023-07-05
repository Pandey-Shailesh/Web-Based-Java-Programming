package onlinemvc.controllers;

import java.util.Iterator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import onlinemvc.beans.Users;
@Controller
public class CategoryController {
@Autowired
CategoryDao categoryDAO;

@RequestMapping("/category")
public ModelAndView showAllCategories() {
	Iterator<Category> categoryIterator = categoryDAO.allCategories();
		return new ModelAndView("category","data",categoryIterator);
	
}




}
