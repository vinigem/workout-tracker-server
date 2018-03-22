package com.vini.workouttracker.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vini.workouttracker.dao.ICategoryDAO;
import com.vini.workouttracker.model.Category;
import com.vini.workouttracker.service.ICategoryService;

public class CategoryService implements ICategoryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryService.class);

	@Autowired
	private ICategoryDAO categoryDAO;

	@Override
	public List<Category> getAllCategories() {
		return categoryDAO.getAllCategories();
	}

	@Override
	public boolean saveCategory(Category category) {
		boolean status = false;
		try {
			categoryDAO.saveCategory(category);
			status = true;
		}catch (Exception e) {
			LOGGER.error("Error while saving category. {}", e);
		}
		return status;
	}

	@Override
	public boolean deleteCategory(long categoryId) {
		boolean status = false;
		try {
			categoryDAO.deleteCategory(categoryId);
			status = true;
		}catch (Exception e) {
			LOGGER.error("Error while deleting category with id[{}]. {}", categoryId, e);
		}
		return status;
	}

}
