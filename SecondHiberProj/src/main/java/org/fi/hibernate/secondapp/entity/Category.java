package org.fi.hibernate.secondapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category_0029")
public class Category {
	
	@Id
	@Column(name="categoryId")
	@GeneratedValue(generator="increment")
	int categoryId;
	@Column(name="categoryName")
	String categoryName;
	@Column(name="categoryDescription")
	String categoryDescription;
	@Column(name="categoryImageUrl")
	String categoryImageUrl;

	public Category() {

	}

	public Category(int categoryId, String categoryName, String categoryDescription, String categoryImageUrl) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
		this.categoryImageUrl = categoryImageUrl;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public String getCategoryImageUrl() {
		return categoryImageUrl;
	}

	public void setCategoryImageUrl(String categoryImageUrl) {
		this.categoryImageUrl = categoryImageUrl;
	}
}
