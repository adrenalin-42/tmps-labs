package com.tmps.domain.models;

import java.util.Collections;
import java.util.List;

public class SimpleToDoItem implements IToDoItem, ITaskComponent {
	private String description;
	private boolean completed;

	public SimpleToDoItem(String taskDescription, boolean completed) {
		this.description = taskDescription;
		this.completed = completed;
	}

	public String getDescription() {
		return description;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	@Override
	public void addTask(ITaskComponent task) {
		// Do nothing, as SimpleToDoItems cannot contain subtasks
		//throw new UnsupportedOperationException("SimpleToDoItem cannot contain subtasks");
	}

	@Override
	public void removeTask(ITaskComponent task) {
		// Do nothing, as SimpleToDoItems cannot contain subtasks
		//throw new UnsupportedOperationException("SimpleToDoItem cannot contain subtasks");
	}

	@Override
	public List<ITaskComponent> getTasks() {
		return Collections.emptyList(); // Return an empty list as it has no subtasks
	}

	@Override
	public void markCompleted() {
		this.completed = true;
	}

	@Override
	public void printData() {
		System.out.println(this.description + " status: " + (this.completed ? "completed" : "not completed"));
	}

}