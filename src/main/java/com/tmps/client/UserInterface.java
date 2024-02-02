package com.tmps.client;

import com.tmps.domain.models.Priority;
import com.tmps.domain.models.PriorityToDoItem;
import com.tmps.domain.models.TaskList;
import com.tmps.domain.models.ToDoItem;

public class UserInterface {
	private TaskList taskList; // Dependency injection for SRP

	public UserInterface(TaskList taskList) {
		this.taskList = taskList;
	}

	public void test() {
		//TaskList taskList = new TaskList();
		taskList.addItem(new ToDoItem("Buy groceries"));
		taskList.addItem(new PriorityToDoItem("Finish project", Priority.HIGH));

		// Process items without breaking functionality, regardless of their type
		for (ToDoItem item : taskList.getItems()) {
			System.out.println(item.getDescription());
		}
	}

}