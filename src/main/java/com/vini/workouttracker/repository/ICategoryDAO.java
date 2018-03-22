package com.vini.workouttracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vini.workouttracker.model.Category;

public interface ICategoryDAO extends MongoRepository<Category, String> {
	
}
