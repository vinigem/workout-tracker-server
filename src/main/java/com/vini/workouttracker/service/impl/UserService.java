package com.vini.workouttracker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vini.workouttracker.model.User;
import com.vini.workouttracker.repository.IUserDAO;
import com.vini.workouttracker.service.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserDAO userDAO;

	@Override
	public User saveUser(User user) {
		return userDAO.save(user);
	}

}
