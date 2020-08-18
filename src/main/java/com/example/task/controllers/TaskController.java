package com.example.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.task.model.Task;
import com.example.task.services.TaskService;

@Controller
public class TaskController {
	
	
	@Autowired
	private TaskService taskservice;
	
	
	@RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("tasks", taskservice.listAllTasks());
        return "tasks";
    }
	
	@RequestMapping(value = "/tasks/finished", method = RequestMethod.GET)
    public String listFinished(Model model){
        model.addAttribute("tasks", taskservice.listFinishedTasks());
        return "tasks";
    }
	
	

    @RequestMapping("task/{id}")
    public String showTask(@PathVariable Integer id, Model model){
        model.addAttribute("task", taskservice.getTaskById(id));
        return "tasksshow";
    }
            

    @RequestMapping("task/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("task", taskservice.getTaskById(id));
        return "formtask";
    }
    
    
    @RequestMapping("task/new")
    public String newTask(Model model){
        model.addAttribute("task", new Task());
        return "formtask";
    }

    @RequestMapping(value = "task", method = RequestMethod.POST)
    public String saveTask(Task task){
    	taskservice.saveTask(task);
        return "redirect:/task/" + task.getId();
    }

    @RequestMapping("task/delete/{id}")
    public String delete(@PathVariable Integer id){
    	taskservice.deletTask(id);
        return "redirect:/tasks";
    }

}
