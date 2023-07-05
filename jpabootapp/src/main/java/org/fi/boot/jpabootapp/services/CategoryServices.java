package org.fi.boot.jpabootapp.services;

import java.util.Iterator;

import org.fi.boot.jpabootapp.dto.CategoryDTO;

public interface CategoryServices {
	boolean addNewCategory(CategoryDTO objCategoryDTO);
	boolean deleteCategory(int categoryId);
	Iterator<CategoryDTO> allCategories();
}
