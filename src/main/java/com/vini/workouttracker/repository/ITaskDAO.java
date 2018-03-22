package com.vini.workouttracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vini.workouttracker.model.Task;

public interface ITaskDAO extends MongoRepository<Task, String> {}
