package com.tmps.domain.models;

public class PrioritySimpleToDoItem extends SimpleToDoItem {
	private Priority priority;

	public PrioritySimpleToDoItem(String taskDescription, boolean completed, Priority priorityLevel) {
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