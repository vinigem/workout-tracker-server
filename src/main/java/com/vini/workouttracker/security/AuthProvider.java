package com.vini.workouttracker.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import com.vini.workouttracker.model.User;
import com.vini.workouttracker.repository.IUserDAO;

@Component
public class AuthProvider implements AuthenticationProvider {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthProvider.class);
	
	@Autowired
	private IUserDAO userDAO;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();

		LOGGER.info("Username: {}, Password: {}", username, password);

		User user = userDAO.findByUsername(username);
		if (user != null) {
			LOGGER.info("User found. Authentication successfull");
			Authentication token = new UsernamePasswordAuthenticationToken(username, password, AuthorityUtils.createAuthorityList("USER"));
			return token;
		} 
		LOGGER.error("User {} Not found. Authentication failed", username);
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
