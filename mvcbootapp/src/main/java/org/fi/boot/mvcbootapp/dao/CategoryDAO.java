package org.fi.boot.mvcbootapp.dao;

import java.util.Iterator;

public class CategoryDAO {

	boolean addNewCategory( Category objCategory);
	boolean deleteCategory(int categoryId);
	Iterator<Category> allCategories();
	
	
	
}
