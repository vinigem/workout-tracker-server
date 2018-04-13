package com.vini.workouttracker.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vini.workouttracker.AppContants;
import com.vini.workouttracker.model.Task;
import com.vini.workouttracker.repository.ITaskDAO;
import com.vini.workouttracker.service.ITaskService;

/**
 * Task service class
 * @author Vinit Kumar
 *
 */
@Service
public class TaskService implements ITaskService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TaskService.class);
	
	@Autowired
	private ITaskDAO taskDAO;

	/**
	 * get all tasks
	 * @param username the username
	 * @return tasks
	 */
	@Override
	public List<Task> getAllTasks(String username) {
		return taskDAO.findByUser(username);
	}

	
	/**
	 * save or update task
	 * @param task the task object
	 * @param update the update flag
	 * @return status
	 */
	@Override
	public String saveTask(Task task, boolean update) {
		String status = null;
		try {
			if(!update) {
				if(taskDAO.exists(task.getTitle())) {
					return AppContants.EXIST;
				}
			}	
			taskDAO.save(task);
			status = AppContants.SUCCESS;
		}catch (Exception e) {
			LOGGER.error("Error while saving task. {}", e);
			status = AppContants.ERROR;
		}
		return status;
	}

	
	/**
	 * delete task
	 * @param the task title
	 * @param status
	 */
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
