package com.vini.workouttracker.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vini.workouttracker.dao.ICategoryDAO;
import com.vini.workouttracker.model.Category;
import com.vini.workouttracker.repository.DataStore;

@Repository
public class CategoryDAO implements ICategoryDAO {

	@Override
	public List<Category> getAllCategories() {
		return DataStore.CATEGORIES;
	}

	@Override
	public void saveCategory(Category category) {
		if(category.getId() == null) {
			category.setId((long) DataStore.CATEGORIES.size());
			DataStore.CATEGORIES.add(category);
		} else {
			DataStore.CATEGORIES.set(category.getId().intValue(), category);
		}		
	}

	@Override
	public void deleteCategory(Long categoryId) {
		DataStore.CATEGORIES.remove(categoryId.intValue());
	}

}
