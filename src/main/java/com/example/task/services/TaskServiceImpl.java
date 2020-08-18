package com.example.task.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.task.model.Task;
import com.example.task.repositories.TaskRepositories;

@Service
public class TaskServiceImpl  implements TaskService {		
	private TaskRepositories taskRepositories;
		
	@Autowired
	public void setTaskRepositories(TaskRepositories taskRepositories) {
		this.taskRepositories = taskRepositories;
	}

	@Override
	public Iterable<Task> listAllTasks() {
		return taskRepositories.findAll();
	}

	@Override
	public Task getTaskById(Integer id) {
		return taskRepositories.findOne(id);
	}

	@Override
	public Task saveTask(Task task) {
		return taskRepositories.save(task);
	}

	@Override
	public void deletTask(Integer id) {
		taskRepositories.delete(id);		
	}

	@Override
	public Iterable<Task> listFinishedTasks() {
 		return taskRepositories.getFinishedTasks();
	}

	
	
}
