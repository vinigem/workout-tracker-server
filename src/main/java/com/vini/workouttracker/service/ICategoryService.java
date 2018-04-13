package com.vini.workouttracker.service;

import java.util.List;

import com.vini.workouttracker.model.Category;

public interface ICategoryService {

	List<Category> getAllCategories(String username);

	String saveCategory(Category category);

	boolean deleteCategory(String id);

}
