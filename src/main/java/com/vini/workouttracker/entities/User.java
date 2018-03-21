package com.vini.workouttracker.entities;

public class User {
	
	private String username;
	
	private String email;
	
	private String password;
	
	private String role;
	
	public User() {}
	
	public User(String username, String email, String password, String role) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
	}



	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}



	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}



	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}



	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}



	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}



	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}



	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}



	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}



	 /*(non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", password=" + password + ", role="	+ role + "]";
	}

	

}
