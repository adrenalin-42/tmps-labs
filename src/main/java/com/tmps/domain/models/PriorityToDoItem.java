package com.tmps.domain.models;

public class PriorityToDoItem extends ToDoItem {
	private Priority priority;

	public PriorityToDoItem(String taskDescription, boolean completed, Priority priorityLevel) {
		super(taskDescription, completed);
		this.priority = priorityLevel;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	// ...
}