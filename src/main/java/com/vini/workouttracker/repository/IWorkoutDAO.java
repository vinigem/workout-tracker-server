package com.vini.workouttracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vini.workouttracker.model.Workout;

public interface IWorkoutDAO extends MongoRepository<Workout, String> {}
