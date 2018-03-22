package com.vini.workouttracker.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vini.workouttracker.dao.ITaskDAO;
import com.vini.workouttracker.model.Task;
import com.vini.workouttracker.repository.DataStore;

@Repository
public class TaskDAO implements ITaskDAO {

	@Override
	public List<Task> getAllTasks() {
		return DataStore.TASKS;
	}

	@Override
	public void saveTask(Task task) {
		if(task.getId() == null) {
			task.setId((long) DataStore.TASKS.size());
			DataStore.TASKS.add(task);
		} else {
			DataStore.TASKS.set(task.getId().intValue(), task);
		}		
	}

	@Override
	public void deleteTask(Long id) {
		DataStore.TASKS.remove(id.intValue());
	}

}
