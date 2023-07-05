package org.fi.boot.jpabootapp.services;

import java.util.ArrayList;
import java.util.Iterator;

import org.fi.boot.jpabootapp.dto.CategoryDTO;
import org.fi.boot.jpabootapp.dto.ContactDTO;
import org.fi.boot.jpabootapp.entity.Category;
import org.fi.boot.jpabootapp.entity.Contact;
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

	


}
