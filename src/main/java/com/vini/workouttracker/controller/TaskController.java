package com.vini.workouttracker.controller;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vini.workouttracker.model.Task;
import com.vini.workouttracker.service.ITaskService;


@RestController
public class TaskController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TaskController.class);

	@Autowired
	private ITaskService taskService;

	/**
	 * view all tasks
	 * @return tasks
	 */
	@RequestMapping(value="/view-tasks", method = RequestMethod.GET)
	public @ResponseBody List<Task> viewTasks(Principal principal){
		LOGGER.info("Request to fetch all tasks for {}", principal.getName());
		return taskService.getAllTasks(principal.getName());
	}

	/**
	 * save or update task
	 * @param task the task model
	 * @return boolean
	 */
	@RequestMapping(value="/save-task", method = RequestMethod.POST)
	public @ResponseBody boolean saveTask(@RequestBody Task task){
		LOGGER.info("Request to save task: {}", task);
		return taskService.saveTask(task);
	}

	/**
	 * delete task
	 * @param title the task title
	 * @return boolean
	 */
	@RequestMapping(value="/delete-task", method = RequestMethod.POST)
	public @ResponseBody boolean deleteTask(@RequestBody String title){
		LOGGER.info("Request to delete task with title [{}]", title);
		return taskService.deleteTask(title);
	}


}
