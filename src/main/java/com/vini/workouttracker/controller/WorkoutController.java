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

import com.vini.workouttracker.model.TrackData;
import com.vini.workouttracker.model.Workout;
import com.vini.workouttracker.service.IWorkoutService;

@RestController
public class WorkoutController {

	private static final Logger LOGGER = LoggerFactory.getLogger(WorkoutController.class);

	@Autowired
	private IWorkoutService workoutService;

	/**
	 * view all workouts
	 * @return workouts
	 */
	@RequestMapping(value="/view-workouts", method = RequestMethod.GET)
	public @ResponseBody List<Workout> viewWorkouts(Principal principal){
		LOGGER.info("Request to fetch all workouts for {}", principal.getName());
		return workoutService.getAllWorkouts(principal.getName());
	}

	/**
	 * save or update workout
	 * @param workout the workout model
	 * @return boolean
	 */
	@RequestMapping(value="/save-workout", method = RequestMethod.POST)
	public @ResponseBody boolean saveWorkout(@RequestBody Workout workout){
		LOGGER.info("Request to save workout: {}", workout);
		return workoutService.saveWorkout(workout);
	}
	
	/**
	 * get workout tracking data
	 * @return track data
	 */
	@RequestMapping(value="/get-workout-track-data", method = RequestMethod.GET)
	public @ResponseBody TrackData getWorkoutTrackData(Principal principal){
		LOGGER.info("Request to get track data for {}", principal.getName());
		return workoutService.getWorkoutTrackData(principal.getName());
	}
	

}
