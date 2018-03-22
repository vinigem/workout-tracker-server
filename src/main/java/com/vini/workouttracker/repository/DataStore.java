package com.vini.workouttracker.repository;

import java.util.ArrayList;
import java.util.List;

import com.vini.workouttracker.model.Category;
import com.vini.workouttracker.model.Task;
import com.vini.workouttracker.model.Workout;

public class DataStore {

	public static final List<Task> TASKS = new ArrayList<Task>();

	public static final List<Workout> WORKOUTS = new ArrayList<Workout>();

	public static final List<Category> CATEGORIES = new ArrayList<Category>();

}
