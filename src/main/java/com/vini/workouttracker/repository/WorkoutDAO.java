package com.vini.workouttracker.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vini.workouttracker.model.Workout;

@Repository
public class WorkoutDAO implements IWorkoutDAO{

	@Override
	public List<Workout> getAllWorkouts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveWorkout(Workout workout) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteWorkout(long id) {
		// TODO Auto-generated method stub
		
	}

}
