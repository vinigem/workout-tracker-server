package com.vini.workouttracker.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vini.workouttracker.model.Workout;

public interface IWorkoutDAO extends MongoRepository<Workout, String> {
	
	List<Workout> findByUser(String name);
}
