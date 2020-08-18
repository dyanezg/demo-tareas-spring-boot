package com.example.task.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.task.model.Task;

public interface TaskRepositories extends CrudRepository<Task, Integer>{
	
	@Query("select t from Task t where t.finishedTask = 1")
	Iterable<Task> getFinishedTasks();
		
	
}
