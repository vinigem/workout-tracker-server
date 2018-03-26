package com.vini.workouttracker.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vini.workouttracker.model.TrackData;
import com.vini.workouttracker.model.Workout;
import com.vini.workouttracker.repository.ITaskDAO;
import com.vini.workouttracker.repository.IWorkoutDAO;
import com.vini.workouttracker.service.IWorkoutService;
import com.vini.workouttracker.util.DateUtil;

@Service
public class WorkoutService implements IWorkoutService {

	private static final Logger LOGGER = LoggerFactory.getLogger(WorkoutService.class);

	@Autowired
	private IWorkoutDAO workoutDAO;
	
	@Autowired
	private ITaskDAO taskDAO;

	@Override
	public List<Workout> getAllWorkouts() {
		return workoutDAO.findAll();
	}

	@Override
	public boolean saveWorkout(Workout workout) {
		boolean status = false;
		try {
			workoutDAO.save(workout);
			status = true;
		}catch (Exception e) {
			LOGGER.error("Error while saving workout. {}", e);
		}
		return status;

	}

	@Override
	public TrackData getWorkoutTrackData() {
		TrackData trackData = new TrackData();

		List<Workout> workouts = getAllWorkouts();

		float dayWorkoutTime = 0;
		float weekWorkoutTime = 0;
		float monthWorkoutTime = 0;
		Map<String, Float> weekCaloriesBurnt = new HashMap<String, Float>();
		Map<String, Float> monthCaloriesBurnt = new HashMap<String, Float>();
		Map<String, Float> yearCaloriesBurnt = new HashMap<String, Float>();

		for(Workout workout: workouts) {
			Date workoutStartTime = workout.getStartTime();
			Date workoutEndTime = workout.getEndTime();

			float diff = DateUtil.getMinuteDifference(workoutStartTime, workoutEndTime);
			float caloriePerMinute = taskDAO.findOne(workout.getTask()).getCalories();
			
			if(DateUtil.isTodaysDate(workoutStartTime)) {
				dayWorkoutTime += diff;
			}

			if(DateUtil.isCurrentWeeksDate(workoutStartTime)) {
				weekWorkoutTime += diff;

				String day = DateUtil.getDayShortName(workoutStartTime);

				float totalCalories = diff * caloriePerMinute;

				if(weekCaloriesBurnt.containsKey(day)) {
					totalCalories += weekCaloriesBurnt.get(day);
				}

				weekCaloriesBurnt.put(day, totalCalories);
			}

			if(DateUtil.isCurrentMonthsDate(workoutStartTime)) {
				monthWorkoutTime += diff;

				String week = DateUtil.getWeekName(workoutStartTime);

				float totalCalories = diff * caloriePerMinute;

				if(monthCaloriesBurnt.containsKey(week)) {
					totalCalories += monthCaloriesBurnt.get(week);
				}

				monthCaloriesBurnt.put(week, totalCalories);
			}

			if(DateUtil.isCurrentYearsDate(workoutStartTime)) {
				String month = DateUtil.getMonthNo(workoutStartTime);

				float totalCalories = diff * caloriePerMinute;

				if(yearCaloriesBurnt.containsKey(month)) {
					totalCalories += yearCaloriesBurnt.get(month);
				}

				yearCaloriesBurnt.put(month, totalCalories);
			}
		}

		trackData.setDayWorkoutTime(dayWorkoutTime);
		trackData.setWeekWorkoutTime(weekWorkoutTime);
		trackData.setMonthWorkoutTime(monthWorkoutTime);;
		trackData.setWeekCaloriesBurnt(weekCaloriesBurnt);
		trackData.setMonthCaloriesBurnt(monthCaloriesBurnt);
		trackData.setYearCaloriesBurnt(yearCaloriesBurnt);

		return trackData;
	}



}
