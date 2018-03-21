package com.vini.workouttracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vini.workouttracker.model.Workout;

@Service
public class WorkoutService implements IWorkoutService {

	@Override
	public List<Workout> getAllWorkouts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveWorkout(Workout workout) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteWorkout(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
