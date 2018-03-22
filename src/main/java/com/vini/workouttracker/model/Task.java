package com.vini.workouttracker.model;

import java.io.Serializable;

public class Task implements Serializable{

	/** default serial version id */
	private static final long serialVersionUID = 1L;

	/** task id */
	private Long id;

	/** task title */
	private String title;

	/** task note */
	private String note;

	/** task calories burnt per minute */
	private float calories;

	/** task category id */
	private Long categoryId;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
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
	 * @return the categoryId
	 */
	public Long getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", note=" + note + ", calories=" + calories + ", categoryId="
				+ categoryId + "]";
	}


}
