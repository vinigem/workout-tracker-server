package com.vini.workouttracker.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vini.workouttracker.model.Category;
import com.vini.workouttracker.repository.ICategoryDAO;
import com.vini.workouttracker.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryService.class);

	@Autowired
	private ICategoryDAO categoryDAO;

	@Override
	public List<Category> getAllCategories(String username) {
		return categoryDAO.findByUser(username);
	}

	@Override
	public boolean saveCategory(Category category) {
		boolean status = false;
		try {
			categoryDAO.save(category);
			status = true;
		}catch (Exception e) {
			LOGGER.error("Error while saving category. {}", e);
		}
		return status;
	}

	@Override
	public boolean deleteCategory(String id) {
		boolean status = false;
		try {
			categoryDAO.delete(id);
			status = true;
		}catch (Exception e) {
			LOGGER.error("Error while deleting category with id[{}]. {}", id, e);
		}
		return status;
	}

}
