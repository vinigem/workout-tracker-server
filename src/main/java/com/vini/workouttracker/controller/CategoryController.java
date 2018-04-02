package com.vini.workouttracker.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vini.workouttracker.model.Category;
import com.vini.workouttracker.service.ICategoryService;


@RestController
public class CategoryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private ICategoryService categoryService;

	/**
	 * view all categories
	 * @return categories
	 */
	@RequestMapping(value="/view-categories", method = RequestMethod.GET)
	public @ResponseBody List<Category> viewCategories(){
		LOGGER.info("Request to fetch all categories");
		return categoryService.getAllCategories();
	}

	/**
	 * save or update category
	 * @param category the category model
	 * @return boolean
	 */
	@RequestMapping(value="/save-category", method = RequestMethod.POST)
	public @ResponseBody boolean saveCategory(@RequestBody Category category){
		LOGGER.info("Request to save category: {}", category);
		return categoryService.saveCategory(category);
	}

	/**
	 * delete category
	 * @param category the category name
	 * @return boolean
	 */
	@RequestMapping(value="/delete-category", method = RequestMethod.POST)
	public @ResponseBody boolean deleteCategory(@RequestBody String id){
		LOGGER.info("Request to delete category with id [{}]", id);
		return categoryService.deleteCategory(id);
	}
	
	@RequestMapping(value="sum")
	public int sum(){
		return 10+20;
	}


}
