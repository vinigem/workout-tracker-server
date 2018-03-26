package com.vini.workouttracker.service;

import java.util.List;

import com.vini.workouttracker.model.TrackData;
import com.vini.workouttracker.model.Workout;

public interface IWorkoutService {
	
	List<Workout> getAllWorkouts();
	
	boolean saveWorkout(Workout workout);

	TrackData getWorkoutTrackData();
	
}
