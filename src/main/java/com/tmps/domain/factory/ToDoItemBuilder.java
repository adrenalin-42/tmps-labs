package com.tmps.domain.factory;

import com.tmps.domain.models.Priority;
import com.tmps.domain.models.PriorityToDoItem;
import com.tmps.domain.models.ToDoItem;

public class ToDoItemBuilder {
	private String description;
	private boolean completed = false;
	private Priority priority = Priority.LOW; // Add priority field

	public ToDoItemBuilder description(String description) {
		this.description = description;
		return this;
	}

	public ToDoItemBuilder completed(boolean completed) {
		this.completed = completed;
		return this;
	}

	public ToDoItemBuilder priority(Priority priority) { // Builder method for priority
		this.priority = priority;
		return this;
	}

	public ToDoItem build() {
		// Validate data if needed
		if (priority == null) {
			return new ToDoItem(description, completed);
		}
		return new PriorityToDoItem(description, completed, priority);
	}
}