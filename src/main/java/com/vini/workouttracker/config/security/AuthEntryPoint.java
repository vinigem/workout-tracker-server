package com.vini.workouttracker.config.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class AuthEntryPoint extends BasicAuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		System.out.println("AuthEntryPoint.commence(): " + request.getRequestURI());
		System.out.println(authException.getMessage());
		response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName());
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter writer = response.getWriter();
        writer.println("HTTP Status 401 - " + authException.getMessage());
	}
	
	@Override
    public void afterPropertiesSet() throws Exception {
        setRealmName("vChat");
        super.afterPropertiesSet();
    }

}
