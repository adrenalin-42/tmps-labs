package com.tmps.client;

import com.tmps.domain.factory.ToDoItemBuilder;
import com.tmps.domain.models.*;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
	private TaskList taskList; // Dependency injection for SRP

	Scanner myObj;

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

	public void use() {
		while (true) {
			myObj = new Scanner(System.in);

			System.out.println("1. Add a new task");
			System.out.println("2. View To Do list");
			System.out.println("3. Remove a To Do");
			System.out.println("4. Mark a To Do as complete");
			System.out.println("5. View high priority tasks");
			System.out.println("6. Exit");

			int option = myObj.nextInt();
			if (option == 1) {
				add_task();
			} else if (option == 2) {
				view_tasks();
			} else if (option == 3) {
				remove_todo();
			} else if (option == 4) {
				complete_todo();
			} else if (option == 5) {
				view_highpriority();
			} else {
				break;
			}
		}
	}

	public void add_task() {
		System.out.print("Enter task description:");
		String entryDescription = myObj.next();
		System.out.print("Enter if it has been completed:");
		int entryCompleted = myObj.nextInt();
		System.out.print("Enter the priority:");
		String priorityString = myObj.next();
		Priority priorityLevel = null;

		// DeSerialize the state of completeness
		if (priorityString.equals("HIGH")) {
			priorityLevel = Priority.HIGH;
		} else if (priorityString.equals("LOW")) {
			priorityLevel = Priority.LOW;
		}

		taskList.addItem(new ToDoItemBuilder().description(entryDescription).completed(entryCompleted == 1).priority(priorityLevel).build());
		System.out.println("Task added successfully\n");
	}

	public void view_tasks() {
		taskList.printAll();
	}

	public void remove_todo() {
		taskList.printAll();
		int idToRemove = myObj.nextInt();
		int i = 0;
		IToDoItem selectedItem = null;
		for (IToDoItem item: taskList.getItems()) {
			if (i == idToRemove) {
				selectedItem = item;
			}
		}
		if (selectedItem != null) {
			taskList.removeItem(selectedItem);
		}
	}

	public void complete_todo() {
		taskList.printAll();
		int idToRemove = myObj.nextInt();
		int i = 0;
		IToDoItem selectedItem = null;
		for (IToDoItem item: taskList.getItems()) {
			if (i == idToRemove) {
				selectedItem = item;
			}
		}
		if (selectedItem != null) {
			taskList.addItem(new ToDoItemBuilder().description(selectedItem.getDescription()).completed(true).priority(selectedItem.getPriority()).build());
			taskList.removeItem(selectedItem);
		}
	}

	public void view_highpriority() {
//		List<IToDoItem> allTasks = taskRepository.getAllItems(); // Assuming a task repository
		ITaskIterator priorityTasks = new PriorityTaskIterator(taskList.getItems(), Priority.HIGH);
		while (priorityTasks.hasNext()) {
			IToDoItem task = priorityTasks.next();
			System.out.println("High priority task: " + task.getDescription());
		}
	}
}