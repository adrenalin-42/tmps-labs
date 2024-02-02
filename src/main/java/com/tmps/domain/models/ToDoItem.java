package com.tmps.domain.models;

public class ToDoItem {
	private String description;
	private boolean completed;

	public ToDoItem(String taskDescription) {
		description = taskDescription;
		completed = false;
	}

	public String getDescription() {
		return description;
	}

	public boolean isCompleted() {
		return completed;
	}
}