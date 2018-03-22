package com.vini.workouttracker.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vini.workouttracker.dao.ITaskDAO;
import com.vini.workouttracker.model.Task;
import com.vini.workouttracker.service.ITaskService;

@Service
public class TaskService implements ITaskService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TaskService.class);
	
	@Autowired
	private ITaskDAO taskDAO;

	@Override
	public List<Task> getAllTasks() {
		return taskDAO.getAllTasks();
	}

	@Override
	public boolean saveTask(Task task) {
		boolean status = false;
		try {
			taskDAO.saveTask(task);
			status = true;
		}catch (Exception e) {
			LOGGER.error("Error while saving task. {}", e);
		}
		return status;
	}

	@Override
	public boolean deleteTask(long id) {
		boolean status = false;
		try {
			taskDAO.deleteTask(id);
			status = true;
		}catch (Exception e) {
			LOGGER.error("Error while deleting task with id[{}]. {}", id, e);
		}
		return status;
	}

}
