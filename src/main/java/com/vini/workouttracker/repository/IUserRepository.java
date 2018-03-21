package com.vini.workouttracker.repository;

import com.vini.workouttracker.entities.User;

public interface IUserRepository {
	
	User findByUsername(String username);

	void saveUser(User newUser);
	
}
