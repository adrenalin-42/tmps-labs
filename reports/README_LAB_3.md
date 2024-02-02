# Structural Design Patterns


## Author: Dumitru Moraru

----

## Objectives:
- Study and understand the Structural Design Patterns.
- As a continuation of the previous laboratory work, think about
the functionalities that your system will need to provide to the user.
- Implement some additional functionalities, or create a new
project using structural design patterns.

## Used Design Patterns:
- Decorator
- Composite


## Implementation
**Decorator Pattern:**
- Marking tasks as `Urgent` by wrapping them with a `UrgentTaskDecorator`, 
displaying urgency indicators and potentially sending reminders.
Adds new functionalities to existing tasks without modifying 
their core structure.
- Code snippet:
```java
// Decorator for urgent tasks
public class UrgentTaskDecorator extends TaskDecorator {
	public UrgentTaskDecorator(ToDoItem decoratedTask) {
		super(decoratedTask);
	}

	@Override
	public String getDescription() {
		return "[URGENT] " + decoratedTask.getDescription();
	}
}
```
**Composite:**
- Creating task groups like `WorkTasks` and `ResearchTasks`, containing
individual tasks or even other sub-groups, allowing for complex 
task breakdowns and structured management. It treats groups of tasks 
as single entities, enabling hierarchical organization and management.
- Code snippet:
```java
// Composite task group class
public class TaskGroup implements TaskComponent {
	private List<TaskComponent> tasks;

	public void addTask(TaskComponent task) {
		tasks.add(task);
	}

	// ... other methods for managing tasks within the group
}
```

## Conclusions / Screenshots / Results

In conclusion, incorporating the Decorator and Composite patterns
into my To-Do List App has been a rewarding experience. The Decorator 
pattern provided a flexible way to extend existing tasks with new 
functionalities like urgency indicators and reminders, without altering 
their core structure. This keeps the code clean and adaptable, allowing 
for easy addition of new features in the future. The Composite pattern 
empowered me to create hierarchical task groups, organizing related 
tasks and subtasks for better management and clarity. This proved 
especially useful for complex projects requiring breakdowns and dependencies.

