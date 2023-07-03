package org.fi.spring.springdaojdbc.dao;

import java.util.Iterator;

import org.fi.spring.springdaojdbc.beans.Category;

public interface CategoryDao {

	boolean addNewCategory(Category objCategory);
	boolean deleteCategory(int categoryId);
	Iterator<Category> allCategories();
}
