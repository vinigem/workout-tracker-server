package com.vini.workouttracker.controller;

import java.security.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vini.workouttracker.model.User;
import com.vini.workouttracker.service.IUserService;

@RestController
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private IUserService userService;
	
	/**
	 * login 
	 * @return user
	 */
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public Principal user(Principal principal) {
		LOGGER.info("user logged {}", principal);
		return principal;
	}
	
	/**
	 * register user
	 * @param user the user model
	 * @return boolean
	 */
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public @ResponseBody User register(@RequestBody User user){
		LOGGER.info("Request to register user: {}", user);
		return userService.saveUser(user);
	}

}
