package org.fi.boot.mvcbootapp.controllers;

import org.fi.boot.mvcbootapp.beans.Users;
import org.fi.boot.mvcbootapp.dao.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class CategoryController {

	
	@Autowired
	CategoryDAO objCategoryDAO;
	
	
	
	
	@RequestMapping("/newCategory")
	public void proocessLogin(Model data) {
		data.addAttribute("objCategory", new Category());
	}

	@RequestMapping("/saveCategory")
	public String proocessAuthenticate(@ModelAttribute("objCategory")Category objCategory ) {
		objCategoryDAO.addNewCategory(objCategory);
		return "success";
	}
}
