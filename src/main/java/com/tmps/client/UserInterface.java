package com.tmps.client;

import com.tmps.domain.factory.ToDoItemBuilder;
import com.tmps.domain.models.*;

public class UserInterface {
	private TaskList taskList; // Dependency injection for SRP

	public UserInterface(TaskList taskList) {
		this.taskList = taskList;
	}

	public void test() {
		taskList.addItem(new ToDoItemBuilder().description("Buy groceries").build());
		taskList.addItem(new ToDoItemBuilder().completed(true).description("Finish project").priority(Priority.HIGH).build());
		taskList.addItem(new UrgentTaskDecorator(new ToDoItemBuilder().description("Finish project report").build()));


		// Process items without breaking functionality, regardless of their type
		for (IToDoItem item : taskList.getItems()) {
			System.out.println(item.getDescription() + " status: " + (item.isCompleted() ? "completed" : "not completed"));
		}
	}

	public void test_groups() {
		// Usage example:
		TaskGroup workTasks = new TaskGroup();
		workTasks.addTask(new ToDoItemBuilder().description("Write code").build());
		workTasks.addTask(new ToDoItemBuilder().description("Test features").build());
		TaskGroup researchTasks = new TaskGroup();
		researchTasks.addTask(new ToDoItemBuilder().description("Read papers").build());
		researchTasks.addTask(new ToDoItemBuilder().description("Collect data").build());
		TaskGroup allTasks = new TaskGroup();
		allTasks.addTask(workTasks);
		allTasks.addTask(researchTasks);

		// Mark all tasks as completed
		allTasks.printAll(); // Recursively marks all tasks and subtasks
		allTasks.markCompleted(); // Recursively marks all tasks and subtasks
		allTasks.printAll(); // Recursively marks all tasks and subtasks
	}

}