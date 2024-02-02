package com.tmps.domain.models;

import java.util.List;
import java.util.NoSuchElementException;

// Concrete iterator for filtering tasks by priority
public class PriorityTaskIterator implements ITaskIterator {
	private Priority priority;
	private List<IToDoItem> tasks;
	private int index = 0;

	public PriorityTaskIterator(List<IToDoItem> tasks, Priority priority) {
		this.tasks = tasks;
		this.priority = priority;
	}

	@Override
	public boolean hasNext() {
		while (index < tasks.size()) {
			IToDoItem item = tasks.get(index);
			if (item.getPriority() == priority) {
				return true;
			}
			index++;
		}
		return false;
	}

	@Override
	public IToDoItem next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		return tasks.get(index++);
	}
}