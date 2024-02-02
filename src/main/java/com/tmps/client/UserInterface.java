package com.tmps.client;

import com.tmps.domain.factory.ToDoItemBuilder;
import com.tmps.domain.models.Priority;
import com.tmps.domain.models.TaskList;
import com.tmps.domain.models.ToDoItem;

public class UserInterface {
	private TaskList taskList; // Dependency injection for SRP

	public UserInterface(TaskList taskList) {
		this.taskList = taskList;
	}

	public void test() {
		taskList.addItem(new ToDoItemBuilder().description("Buy groceries").build());
		taskList.addItem(new ToDoItemBuilder().completed(true).description("Finish project").priority(Priority.HIGH).build());

		// Process items without breaking functionality, regardless of their type
		for (ToDoItem item : taskList.getItems()) {
			System.out.println(item.getDescription() + " status: " + (item.isCompleted() ? "completed" : "not completed"));
		}
	}

}