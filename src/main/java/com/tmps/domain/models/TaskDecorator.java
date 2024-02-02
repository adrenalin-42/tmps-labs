package com.tmps.domain.models;

public abstract class TaskDecorator implements IToDoItem {
	protected IToDoItem decoratedTask;

	public TaskDecorator(IToDoItem decoratedTask) {
		this.decoratedTask = decoratedTask;
	}

	// Delegate methods to the decorated task
	@Override
	public String getDescription() {
		return decoratedTask.getDescription();
	}

	@Override
	public boolean isCompleted() {
		return decoratedTask.isCompleted();
	}

	@Override
	public void setCompleted(boolean completed) {
		decoratedTask.setCompleted(completed);
	}

	@Override
	public Priority getPriority() {
		return decoratedTask.getPriority();
	}

	@Override
	public void printData() {
		decoratedTask.printData();
	}

	// ... other delegated methods
}