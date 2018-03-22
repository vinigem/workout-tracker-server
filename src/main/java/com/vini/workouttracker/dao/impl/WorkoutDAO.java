package com.vini.workouttracker.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vini.workouttracker.dao.IWorkoutDAO;
import com.vini.workouttracker.model.Workout;
import com.vini.workouttracker.repository.DataStore;

@Repository
public class WorkoutDAO implements IWorkoutDAO{

	@Override
	public List<Workout> getAllWorkouts() {
		return DataStore.WORKOUTS;
	}

	@Override
	public void saveWorkout(Workout workout) {
		if(workout.getId() == null) {
			workout.setId((long) DataStore.WORKOUTS.size());
			DataStore.WORKOUTS.add(workout);
		} else {
			DataStore.WORKOUTS.set(workout.getId().intValue(), workout);
		}		
	}

}
