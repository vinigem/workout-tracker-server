package com.vini.workouttracker.dao;

import java.util.List;

import com.vini.workouttracker.model.Workout;

public interface IWorkoutDAO {

	List<Workout> getAllWorkouts();

	void saveWorkout(Workout workout);
	
}
