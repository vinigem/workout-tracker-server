package com.vini.workouttracker.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class AuthEntryPoint extends BasicAuthenticationEntryPoint {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthEntryPoint.class);

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx)
			throws IOException, ServletException {
		response.addHeader("WWW-Authenticate", "Basic realm=\"" + getRealmName() + "\"");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		LOGGER.error("HTTP Status 401 - {}", authEx.getMessage());
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		setRealmName("WorkoutTracker");
		super.afterPropertiesSet();
	}
}
