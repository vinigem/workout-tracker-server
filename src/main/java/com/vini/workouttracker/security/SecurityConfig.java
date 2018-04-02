package com.vini.workouttracker.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.vini.workouttracker.model.User;
import com.vini.workouttracker.repository.IUserDAO;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private IUserDAO userDAO;
	
	@Autowired
	private AuthEntryPoint authEntryPoint;

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
	}

	@Bean
	protected UserDetailsService userDetailsService() {
		return new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				User user = userDAO.findByUsername(username);
				if (user != null) {
					return new org.springframework.security.core.userdetails.User(user.getUsername(),
							user.getPassword(), true, true, true, true, AuthorityUtils.createAuthorityList("USER"));
				} else {
					throw new UsernameNotFoundException("could not find the user '" + username + "'");
				}
			}

		};
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/login", "/register").permitAll()
			.anyRequest().fullyAuthenticated()
		.and()
			.logout().permitAll()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST"))
		.and()
			.httpBasic()
			.authenticationEntryPoint(authEntryPoint)
		.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
			.csrf().disable();			
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS").allowedOrigins("*")
				.allowedHeaders("*");
			}
		};
	}
		
}