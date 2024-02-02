package com.tmps.domain.models;

import java.util.List;

public interface IToDoItemRepository {
	List<ToDoItem> getAllItems();
	void saveItem(ToDoItem item);
	void removeItem(ToDoItem item);
}
