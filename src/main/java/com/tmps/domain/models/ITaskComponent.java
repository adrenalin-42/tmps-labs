package com.tmps.domain.models;

import java.util.List;

public interface ITaskComponent {
	void addTask(ITaskComponent task);
	void removeTask(ITaskComponent task);
	List<ITaskComponent> getTasks();
	void markCompleted(); // Example method for composite behavior
	void printData();
}