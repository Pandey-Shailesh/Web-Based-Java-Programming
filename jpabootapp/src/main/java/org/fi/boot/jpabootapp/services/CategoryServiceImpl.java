package org.fi.boot.jpabootapp.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

import org.fi.boot.jpabootapp.dto.CategoryDTO;
import org.fi.boot.jpabootapp.entity.Category;
import org.fi.boot.jpabootapp.repository.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryServices {

	
	@Autowired
	CategoryRepository categoryRepository;
	
	
	
	@Override
	public boolean addNewCategory(CategoryDTO objCategoryDTO) {
		Category objCategory = new Category();
		BeanUtils.copyProperties(objCategoryDTO, objCategory);
		if (categoryRepository.save(objCategory)!=null) {
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public boolean deleteCategory(int categoryId) {
		categoryRepository.deleteById(categoryId);
		return true;
	}

	@Override
	public Iterator<CategoryDTO> allCategories() {
		Iterator<Category> iter = categoryRepository.findAll().iterator();
		ArrayList<CategoryDTO> list = new ArrayList<>();
		
		while (iter.hasNext()) {
			Category objCategory = iter.next();
			CategoryDTO categoryDTO= new CategoryDTO();
			BeanUtils.copyProperties(objCategory, categoryDTO);
			list.add(categoryDTO);
		}
		return list.iterator();
	}

	@Override
	public CategoryDTO getCategoryByID(int categoryId) {
		Optional<Category> optContact= categoryRepository.findById(categoryId);
		if (optContact.isPresent()) {
			Category objCategory = optContact.get();
			CategoryDTO CategoryDTO= new CategoryDTO();
			BeanUtils.copyProperties(objCategory, CategoryDTO);
			return CategoryDTO;
		}
		return null;
	}

	@Override
	public CategoryDTO getCategoryByCategoryDescription(String categoryDescription) {
		Optional<Category> optCategory= categoryRepository.findByCategoryDescription(categoryDescription);
		if (optCategory.isPresent()) {
			Category objCategory = optCategory.get();
			CategoryDTO CategoryDTO= new CategoryDTO();
			BeanUtils.copyProperties(objCategory, CategoryDTO);
			return CategoryDTO;
		}
		return null;
	}

	@Override
	public CategoryDTO getCategoryByCategoryName(String categoryName) {
		Optional<Category> optCategory= categoryRepository.findByCategoryName(categoryName);
		if (optCategory.isPresent()) {
			Category objCategory = optCategory.get();
			CategoryDTO CategoryDTO= new CategoryDTO();
			BeanUtils.copyProperties(objCategory, CategoryDTO);
			return CategoryDTO;
		}
		return null;
	}

	@Override
	public Iterator<CategoryDTO> getCategoryByCategoryImageUrl(String categoryImageUrl) {
		Iterator<Category> iters =  categoryRepository.findByCategoryImageUrl(categoryImageUrl).iterator();
		ArrayList<CategoryDTO> list = new ArrayList<>();
		
		while (iters.hasNext()) {
			Category objCategory = iters.next();
			CategoryDTO CategoryDTO= new CategoryDTO();
			BeanUtils.copyProperties(objCategory, CategoryDTO);
			list.add(CategoryDTO);
		}
		return list.iterator();
	}

	


}
