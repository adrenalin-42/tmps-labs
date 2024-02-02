package com.tmps.domain.models;

import java.util.List;

public interface IToDoItemRepository {
	List<IToDoItem> getAllItems();
	void saveItem(IToDoItem item);
	void removeItem(IToDoItem item);
}
