package com.vini.workouttracker.model;

import java.io.Serializable;
import java.util.Map;

public class TrackData implements Serializable{

	/** default serial version id */
	private static final long serialVersionUID = 1L;
	
	private float dayWorkoutTime;
	
	private float weekWorkoutTime;
	
	private float monthWorkoutTime;
	
	private Map<String, Float> weekCaloriesBurnt;
	
	private Map<String, Float> monthCaloriesBurnt;
	
	private Map<String, Float> yearCaloriesBurnt;
		
	/**
	 * @return the dayWorkoutTime
	 */
	public float getDayWorkoutTime() {
		return dayWorkoutTime;
	}

	/**
	 * @param dayWorkoutTime the dayWorkoutTime to set
	 */
	public void setDayWorkoutTime(float dayWorkoutTime) {
		this.dayWorkoutTime = dayWorkoutTime;
	}

	/**
	 * @return the weekWorkoutTime
	 */
	public float getWeekWorkoutTime() {
		return weekWorkoutTime;
	}

	/**
	 * @param weekWorkoutTime the weekWorkoutTime to set
	 */
	public void setWeekWorkoutTime(float weekWorkoutTime) {
		this.weekWorkoutTime = weekWorkoutTime;
	}

	/**
	 * @return the monthWokoutTime
	 */
	public float getMonthWorkoutTime() {
		return monthWorkoutTime;
	}

	/**
	 * @param monthWokoutTime the monthWokoutTime to set
	 */
	public void setMonthWorkoutTime(float monthWorkoutTime) {
		this.monthWorkoutTime = monthWorkoutTime;
	}

	/**
	 * @return the weekCaloriesBurnt
	 */
	public Map<String, Float> getWeekCaloriesBurnt() {
		return weekCaloriesBurnt;
	}

	/**
	 * @param weekCaloriesBurnt the weekCaloriesBurnt to set
	 */
	public void setWeekCaloriesBurnt(Map<String, Float> weekCaloriesBurnt) {
		this.weekCaloriesBurnt = weekCaloriesBurnt;
	}

	/**
	 * @return the monthCaloriesBurnt
	 */
	public Map<String, Float> getMonthCaloriesBurnt() {
		return monthCaloriesBurnt;
	}

	/**
	 * @param monthCaloriesBurnt the monthCaloriesBurnt to set
	 */
	public void setMonthCaloriesBurnt(Map<String, Float> monthCaloriesBurnt) {
		this.monthCaloriesBurnt = monthCaloriesBurnt;
	}

	/**
	 * @return the yearCaloriesBurnt
	 */
	public Map<String, Float> getYearCaloriesBurnt() {
		return yearCaloriesBurnt;
	}

	/**
	 * @param yearCaloriesBurnt the yearCaloriesBurnt to set
	 */
	public void setYearCaloriesBurnt(Map<String, Float> yearCaloriesBurnt) {
		this.yearCaloriesBurnt = yearCaloriesBurnt;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TrackData [dayWorkoutTime=" + dayWorkoutTime + ", weekWorkoutTime=" + weekWorkoutTime
				+ ", monthWorkoutTime=" + monthWorkoutTime + ", weekCaloriesBurnt=" + weekCaloriesBurnt
				+ ", monthCaloriesBurnt=" + monthCaloriesBurnt + ", yearCaloriesBurnt=" + yearCaloriesBurnt + "]";
	}
	
}
