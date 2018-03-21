package com.vini.workouttracker.repository;

import java.util.ArrayList;
import java.util.List;

import com.vini.workouttracker.entities.User;

public class DataStore {

	private static List<User> users;

	static {
		users = new ArrayList<User>();
		users.add(new User("user", "user@test.com", "passw0rd", "USER"));
		users.add(new User("admin", "admin@test.com", "passw0rd", "ADMIN"));
	}

	public static User getUserByUsername(String userName) {
		return users.stream().filter(user -> user.getUsername().equals(userName)).findFirst().orElse(null);
	}

	public static void saveUser(User newUser) {
		users.add(newUser);
	}

}
