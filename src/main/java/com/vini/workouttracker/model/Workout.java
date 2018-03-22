package com.vini.workouttracker.model;

import java.io.Serializable;
import java.util.Date;

public class Workout implements Serializable {

	/** default serial version id */
	private static final long serialVersionUID = 1L;

	/** workout id */
	private Long id;

	/** workout task id */
	private Long taskId;

	/** workout start time */
	private Date startTime;

	/** workout end time */
	private Date endTime;

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
	 * @return the taskId
	 */
	public Long getTaskId() {
		return taskId;
	}

	/**
	 * @param taskId the taskId to set
	 */
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Workout [id=" + id + ", taskId=" + taskId + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}


}
