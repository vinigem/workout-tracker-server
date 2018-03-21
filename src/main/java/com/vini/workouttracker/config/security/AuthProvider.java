package com.vini.workouttracker.config.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.vini.workouttracker.entities.User;
import com.vini.workouttracker.repository.IUserRepository;

@Component
public class AuthProvider implements AuthenticationProvider {
	
	@Autowired
	private IUserRepository userRepository;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		List<GrantedAuthority> grantedAuths = null;
		Authentication authToken = null;

		if(null != authentication){
			grantedAuths = new ArrayList<GrantedAuthority>();
			String userName = authentication.getName();
			String password = (String) authentication.getCredentials();
			
			User user = userRepository.findByUsername(userName);

			if(null != user  && user.getPassword().equals(password)) {
				grantedAuths.add(new SimpleGrantedAuthority(user.getRole()));
				authToken = new UsernamePasswordAuthenticationToken(userName, password, grantedAuths);

			}
		}
		return authToken;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
