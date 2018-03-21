package com.vini.workouttracker.repository;

import org.springframework.stereotype.Repository;

import com.vini.workouttracker.entities.User;

@Repository
public class UserRepository implements IUserRepository {

	@Override
	public User findByUsername(String username) {
		return DataStore.getUserByUsername(username);
	}

	@Override
	public void saveUser(User newUser) {
		DataStore.saveUser(newUser);
	}

}
