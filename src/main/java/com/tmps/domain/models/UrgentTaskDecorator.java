package com.tmps.domain.models;

// Decorator for urgent tasks
public class UrgentTaskDecorator extends TaskDecorator {
	public UrgentTaskDecorator(IToDoItem decoratedTask) {
		super(decoratedTask);
	}

	@Override
	public String getDescription() {
		return "[URGENT] " + decoratedTask.getDescription(); // Add urgency indicator
	}

	// ... additional methods for urgent task behavior (e.g., reminders)
}