package com.vini.workouttracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.vini.workouttracker.security.SecurityConfig;

@SpringBootApplication
@Import({SecurityConfig.class})
public class Application {
	
	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
