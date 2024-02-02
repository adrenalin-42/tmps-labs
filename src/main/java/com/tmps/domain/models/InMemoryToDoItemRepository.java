package com.tmps.domain.models;

import java.util.ArrayList;
import java.util.List;

public class InMemoryToDoItemRepository implements IToDoItemRepository {

	List<IToDoItem> items = new ArrayList<>();
	@Override
	public List<IToDoItem> getAllItems() {
		return items;
	}

	@Override
	public void saveItem(IToDoItem item) {
		items.add(item);
	}

	@Override
	public void removeItem(IToDoItem item) {
		items.remove(item);
	}
}