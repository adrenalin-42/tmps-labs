package com.tmps.domain.models;

import java.util.List;

public class TaskList implements IToDoItemAdder, IToDoItemRemover {
	private static TaskList instance = null;
	private List<IToDoItem> items;

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
	public void addItem(IToDoItem item) {
		items.add(item);
	}

	@Override
	public void removeItem(SimpleToDoItem item) {
		items.remove(item);
	}

	public List<IToDoItem> getItems() {
		return this.items;
	}

	// Methods for managing the collection of to-do items
	// ...
}