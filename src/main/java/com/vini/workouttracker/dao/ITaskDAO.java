package com.vini.workouttracker.dao;

import java.util.List;

import com.vini.workouttracker.model.Task;

public interface ITaskDAO {

	List<Task> getAllTasks();

	void saveTask(Task task);

	void deleteTask(Long id);

}
