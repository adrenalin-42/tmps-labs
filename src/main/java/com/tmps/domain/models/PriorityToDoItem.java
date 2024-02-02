package com.tmps.domain.models;

public class PriorityToDoItem extends ToDoItem {
	private Priority priority;

	public PriorityToDoItem(String taskDescription, Priority priorityLevel) {
		super(taskDescription);
		this.priority = priorityLevel;
	}

	// ...
}