package com.tmps.domain.models;

public class ToDoItem {
	private String description;
	private boolean completed;

	public ToDoItem(String taskDescription, boolean completed) {
		this.description = taskDescription;
		this.completed = completed;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
}