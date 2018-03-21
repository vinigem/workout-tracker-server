package com.vini.workouttracker.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vini.workouttracker.entities.User;
import com.vini.workouttracker.repository.IUserRepository;

@Service
public class UserService implements IUserService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private IUserRepository userRepository;

	/**
	 * save user
	 * @param user the user dto
	 */
	@Override
	public boolean saveUser(User newUser) {
		boolean saveStatus = false;
		
		newUser.setRole("USER");
		try{
			userRepository.saveUser(newUser);
			saveStatus = true;
		}catch (Exception e) {
			LOGGER.error("Error while saving User. {}", e);
		}
		return saveStatus;
	}

}