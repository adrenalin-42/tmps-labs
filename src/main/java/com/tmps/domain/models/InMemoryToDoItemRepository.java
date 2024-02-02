package com.tmps.domain.models;

import java.util.ArrayList;
import java.util.List;

public class InMemoryToDoItemRepository implements IToDoItemRepository {

	List<ToDoItem> items = new ArrayList<>();
	@Override
	public List<ToDoItem> getAllItems() {
		return items;
	}

	@Override
	public void saveItem(ToDoItem item) {
		items.add(item);
	}

	@Override
	public void removeItem(ToDoItem item) {
		items.remove(item);
	}
}