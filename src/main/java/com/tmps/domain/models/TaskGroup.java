package com.tmps.domain.models;

import java.util.ArrayList;
import java.util.List;

// Composite task group class
public class TaskGroup implements ITaskComponent {
	private List<ITaskComponent> tasks;

	public TaskGroup() {
		tasks = new ArrayList<>();
	}

	public void printAll() {
		for (ITaskComponent taskComponent: tasks) {
			taskComponent.printData(); // Recursively mark subtasks as completed
		}
	}

	@Override
	public void addTask(ITaskComponent task) {
		tasks.add(task);
	}

	@Override
	public void removeTask(ITaskComponent task) {
		tasks.remove(task);
	}

	@Override
	public List<ITaskComponent> getTasks() {
		return tasks;
	}

	@Override
	public void markCompleted() {
		for (ITaskComponent task : tasks) {
			task.markCompleted(); // Recursively mark subtasks as completed
		}
	}

	@Override
	public void printData() {
		for (ITaskComponent task : tasks) {
//			System.out.println("Group: ");
			task.printData(); // Recursively mark subtasks as completed
		}
	}
	// ... other methods for managing tasks within the group
}