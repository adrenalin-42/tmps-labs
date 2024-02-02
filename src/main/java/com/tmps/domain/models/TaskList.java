package com.tmps.domain.models;

import java.util.ArrayList;
import java.util.List;

public class TaskList implements IToDoItemAdder, IToDoItemRemover {
	private static TaskList instance = null;
	private List<ToDoItem> items;

	public static TaskList getInstance(IToDoItemRepository repository) {
		if (instance == null) {
			instance = new TaskList(repository);
		}
		return instance;
	}

	public TaskList(IToDoItemRepository repository) {
		items = repository.getAllItems();
	}

	@Override
	public void addItem(ToDoItem item) {
		items.add(item);
	}

	@Override
	public void removeItem(ToDoItem item) {
		items.remove(item);
	}

	public List<ToDoItem> getItems() {
		return this.items;
	}

	// Methods for managing the collection of to-do items
	// ...
}