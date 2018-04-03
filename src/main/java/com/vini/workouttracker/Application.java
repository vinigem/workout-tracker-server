package com.vini.workouttracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.vini.workouttracker")
public class Application {
	
	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}
		
}
