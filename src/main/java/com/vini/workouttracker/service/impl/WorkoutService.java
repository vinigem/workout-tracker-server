package com.vini.workouttracker.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vini.workouttracker.dao.IWorkoutDAO;
import com.vini.workouttracker.model.Workout;
import com.vini.workouttracker.service.IWorkoutService;

@Service
public class WorkoutService implements IWorkoutService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WorkoutService.class);
	
	@Autowired
	private IWorkoutDAO workoutDAO;

	@Override
	public List<Workout> getAllWorkouts() {
		return workoutDAO.getAllWorkouts();
	}

	@Override
	public boolean saveWorkout(Workout workout) {
		boolean status = false;
		try {
			workoutDAO.saveWorkout(workout);
			status = true;
		}catch (Exception e) {
			LOGGER.error("Error while saving workout. {}", e);
		}
		return status;
	
	}

}
