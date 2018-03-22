package com.vini.workouttracker.service;

import java.util.List;

import com.vini.workouttracker.model.Task;

public interface ITaskService {

	List<Task> getAllTasks();

	boolean saveTask(Task task);

	boolean deleteTask(String title);
}
