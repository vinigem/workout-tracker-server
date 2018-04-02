package com.vini.workouttracker.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vini.workouttracker.model.Task;

public interface ITaskDAO extends MongoRepository<Task, String> {

	List<Task> findByUser(String name);
}
