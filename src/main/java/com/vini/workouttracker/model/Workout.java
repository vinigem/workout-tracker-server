package com.vini.workouttracker.model;

import java.io.Serializable;

public class Workout implements Serializable {

	/** default serial version id */
	private static final long serialVersionUID = 1L;
	
	/** workout id */
	private long id;

	/** workout title */
	private String title;

	/** workout note */
	private String note;

	/** workout calories burnt per minute */
	private float calories;

	/** workout category */
	private Category category;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

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
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Workout [id=" + id + ", title=" + title + ", note=" + note + ", calories=" + calories + ", category="
				+ category + "]";
	}

	
}
