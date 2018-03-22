package com.vini.workouttracker.dao;

import java.util.List;

import com.vini.workouttracker.model.Category;

public interface ICategoryDAO {
	
	List<Category> getAllCategories();
	
	void saveCategory(Category category);
	
	void deleteCategory(Long categoryId);

}
