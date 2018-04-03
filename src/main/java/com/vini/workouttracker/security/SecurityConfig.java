package com.vini.workouttracker.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import com.vini.workouttracker.model.User;
import com.vini.workouttracker.repository.IUserDAO;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

	@Autowired
	private IUserDAO userDAO;
	
	@Autowired
	private AuthEntryPoint authEntryPoint;

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(new BCryptPasswordEncoder(8));
	}

	@Bean
	protected UserDetailsService userDetailsService() {
		return new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				User user = userDAO.findByUsername(username);
				if (user != null) {
					LOGGER.info("User found. Authentication successfull");
					return new org.springframework.security.core.userdetails.User(user.getUsername(),
							user.getPassword(), true, true, true, true, AuthorityUtils.createAuthorityList("USER"));
				} else {
					LOGGER.error("User Not found. Authentication failed");
					throw new UsernameNotFoundException("could not find the user '" + username + "'");
				}
			}

		};
	}
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.httpBasic()
		.and()
		.authorizeRequests()
		.antMatchers("/login", "/register").permitAll()
		.anyRequest().authenticated()
		.and()
		.logout().permitAll()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST"))
		.and()
		.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.exceptionHandling()
		.authenticationEntryPoint(authEntryPoint);
	}		
				
}