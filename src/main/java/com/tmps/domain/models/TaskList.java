package com.tmps.domain.models;

import java.util.List;

public class TaskList implements IToDoItemAdder, IToDoItemRemover {
	private static TaskList instance = null;

	IToDoItemRepository repository;
	private List<IToDoItem> items;

	public static TaskList getInstance(IToDoItemRepository repository) {
		if (instance == null) {
			instance = new TaskList(repository);
		}
		return instance;
	}

	public TaskList(IToDoItemRepository repository) {
		items = repository.getAllItems();
		this.repository = repository;
	}

	@Override
	public void addItem(IToDoItem item) {
		repository.saveItem(item);
	}

	@Override
	public void removeItem(IToDoItem item) {
		repository.removeItem(item);
//		items.remove(item);
	}

	public List<IToDoItem> getItems() {
		this.items = repository.getAllItems();
		return this.items;
	}

	public void printAll() {
		int i = 0;
		for (IToDoItem toDoItem: items) {
			System.out.print(i + ". ");
			toDoItem.printData();
			i++;
		}
	}

	// Methods for managing the collection of to-do items
	// ...
}