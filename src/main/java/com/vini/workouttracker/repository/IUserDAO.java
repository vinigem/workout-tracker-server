package com.vini.workouttracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vini.workouttracker.model.User;

public interface IUserDAO extends MongoRepository<User, String> {
	
	public User findByUsername(String username);

}
