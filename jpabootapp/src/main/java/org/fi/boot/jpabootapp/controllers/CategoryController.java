package org.fi.boot.jpabootapp.controllers;


import java.util.Iterator;

import org.fi.boot.jpabootapp.dto.CategoryDTO;
import org.fi.boot.jpabootapp.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
	@Autowired
	CategoryServices categoryServices;
	
	
	@RequestMapping("/allCategory")
	public Iterator<CategoryDTO> getAllCategory() {
		return categoryServices.allCategories();
	}
	@RequestMapping("/deleteCategory/{cid}")
	public boolean deleteContact(@PathVariable("cid")int categoryId) {
		return categoryServices.deleteCategory(categoryId);
	}
	@RequestMapping("/addCategory")
	public boolean addCategory(@RequestBody CategoryDTO objCategoryDTO) {
		return categoryServices.addNewCategory(objCategoryDTO);
	}
	
}
