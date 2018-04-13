package com.vini.workouttracker.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vini.workouttracker.AppContants;
import com.vini.workouttracker.model.Category;
import com.vini.workouttracker.repository.ICategoryDAO;
import com.vini.workouttracker.service.ICategoryService;

/**
 * Category service class
 * @author Vinit Kumar
 *
 */
@Service
public class CategoryService implements ICategoryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryService.class);

	@Autowired
	private ICategoryDAO categoryDAO;

	/**
	 * get all categories
	 * @param username the username
	 * @return categories
	 */
	@Override
	public List<Category> getAllCategories(String username) {
		return categoryDAO.findByUser(username);
	}

	/**
	 * save or update category
	 * @param category the category object
	 * @return the status
	 */
	@Override
	public String saveCategory(Category category) {
		String status = null;
		try {
			if(null == category.getId()) {
				if(categoryExists(category.getName(), category.getUser())) {
					return AppContants.EXIST;
				}
			}	
			categoryDAO.save(category);
			status = AppContants.SUCCESS;
		}catch (Exception e) {
			LOGGER.error("Error while saving category. {}", e);
			status = AppContants.ERROR;
		}
		return status;
	}

	/**
	 * delete category by id
	 * @param id the category id
	 * @return status
	 */
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
	
	
	/** method to check if category for this user already exist or not
	 * @param name category name
	 * @param user username
	 * @return
	 */
	private boolean categoryExists(String name, String user) {
		return categoryDAO.findByNameAndUser(name, user) != null;
	}

}
