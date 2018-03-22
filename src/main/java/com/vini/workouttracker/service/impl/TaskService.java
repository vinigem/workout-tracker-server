package com.vini.workouttracker.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vini.workouttracker.model.Task;
import com.vini.workouttracker.repository.ITaskDAO;
import com.vini.workouttracker.service.ITaskService;

@Service
public class TaskService implements ITaskService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TaskService.class);
	
	@Autowired
	private ITaskDAO taskDAO;

	@Override
	public List<Task> getAllTasks() {
		return taskDAO.findAll();
	}

	@Override
	public boolean saveTask(Task task) {
		boolean status = false;
		try {
			taskDAO.save(task);
			status = true;
		}catch (Exception e) {
			LOGGER.error("Error while saving task. {}", e);
		}
		return status;
	}

	@Override
	public boolean deleteTask(String title) {
		boolean status = false;
		try {
			taskDAO.delete(title);
			status = true;
		}catch (Exception e) {
			LOGGER.error("Error while deleting task with title[{}]. {}", title, e);
		}
		return status;
	}

}
