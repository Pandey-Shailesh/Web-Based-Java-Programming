package org.fi.boot.jpabootapp.services;

import java.util.Iterator;

import org.fi.boot.jpabootapp.dto.CategoryDTO;

public interface CategoryServices {
	boolean addNewCategory(CategoryDTO objCategoryDTO);
	boolean deleteCategory(int categoryId);
	Iterator<CategoryDTO> allCategories();
	public CategoryDTO getCategoryByID(int categoryId);
	public CategoryDTO getCategoryByCategoryDescription(String categoryDescription);
	public CategoryDTO getCategoryByCategoryName(String categoryName);
	public Iterator<CategoryDTO> getCategoryByCategoryImageUrl(String categoryImageUrl);
}
