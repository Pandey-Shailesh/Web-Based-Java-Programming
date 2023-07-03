package org.fi.spring.springdaojdbc.dao;

import java.util.Iterator;

import javax.annotation.PostConstruct;

import org.fi.spring.springdaojdbc.beans.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class CategoryDAOImpl implements CategoryDao {

	
	@Autowired
	Environment environment;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	String sqlAllCategories;
	String sqlInsertCategory;
	String sqlDeleteCategory;
	
	@PostConstruct
	public void initialize() {
		sqlAllCategories=environment.getProperty("sql.allCategories");
		sqlInsertCategory=environment.getProperty("sql.insertCategory");
		sqlDeleteCategory=environment.getProperty("sql.deleteCategory");

	}
	
	
	
	@Override
	public boolean addNewCategory(Category objCategory) {
		int rows= jdbcTemplate.update(sqlInsertCategory,objCategory.getCategoryId(),objCategory.getCategoryName(),objCategory.getCategoryDescription(),objCategory.getCategoryImageUrl());
		if (rows>0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteCategory(int categoryId) {
		int rows= jdbcTemplate.update(sqlDeleteCategory,categoryId);
		if (rows>0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Iterator<Category> allCategories() {
		RowMapper<Category> rowMapper =(result,rowNo)->{
			Category objCategory = new Category();
			objCategory.setCategoryId(result.getInt(1));
			objCategory.setCategoryName(result.getString(2));
			
			objCategory.setCategoryDescription(result.getString(3));
			objCategory.setCategoryImageUrl(result.getString(4));
			
			
			return objCategory;
			
		};
		
		return jdbcTemplate.query(sqlAllCategories, rowMapper).iterator();
	}

}
