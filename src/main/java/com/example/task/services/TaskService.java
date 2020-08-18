package com.example.task.services;

import com.example.task.model.Task;

public interface TaskService {

	Iterable<Task> listAllTasks();
	
	Iterable<Task> listFinishedTasks();
	
	Task getTaskById(Integer id);

	Task saveTask(Task task);

	void deletTask(Integer id);

}
