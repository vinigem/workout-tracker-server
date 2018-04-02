package com.vini.workouttracker.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="task")
public class Task implements Serializable{

	/** default serial version id */
	private static final long serialVersionUID = 1L;

	/** task title */
	@Id
	private String title;

	/** task note */
	private String note;

	/** task calories burnt per minute */
	private float calories;

	/** task category */
	private String category;
	
	/** user */
	private String user;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * @return the calories
	 */
	public float getCalories() {
		return calories;
	}

	/**
	 * @param calories the calories to set
	 */
	public void setCalories(float calories) {
		this.calories = calories;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Task [title=" + title + ", note=" + note + ", calories=" + calories + ", category=" + category
				+ ", user=" + user + "]";
	}

}
