package com.vini.workouttracker.repository;

import java.util.List;

import com.vini.workouttracker.model.Workout;

public interface IWorkoutDAO {

	List<Workout> getAllWorkouts();

	void saveWorkout(Workout workout);

	void deleteWorkout(long id);

}
