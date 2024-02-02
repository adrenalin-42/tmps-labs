# Creational Design Patterns


## Author: Dumitru Moraru

----

## Objectives:
- Study and understand the Creational Design Patterns.
- Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.
- Use some creational design patterns for object instantiation in a sample project.

## Used Design Patterns:
- Singleton
- Builder

## Implementation
**Singleton:**
- We leverage the Singleton pattern to enforce a single `TaskList`
instance, crucial for managing all tasks in one place. It ensures only
one instance exists, promoting centralized task management.
- Code snippet:
```java
public class TaskList {
    private static TaskList instance = null;
    private List<ToDoItem> items;
    
    public static TaskList getInstance(IToDoItemRepository repository) {
        if (instance == null) {
            instance = new TaskList(repository);
        }
        return instance;
    }
}
```
**Builder:**
- The Builder pattern empowers creating different task types (regular,
priority) with granular control over their properties, enhancing 
flexibility and code readability. It offers flexible task creation 
with separate methods for configuring properties.
- Code snippet:
```java
// domain/factory/ToDoItemBuilder.java
public class ToDoItemBuilder {
    private String description;
    private boolean completed = false;
    private Priority priority = Priority.LOW;
    // ... rest of methods
    public ToDoItem build() {
        if (priority == null) {
            return new ToDoItem(description, completed);
        }
        return new PriorityToDoItem(description, completed, priority);
    }
}

// client/UserInteface.java
public class UserInterface {
    public void test() {
        taskList.addItem(new ToDoItemBuilder().description("Buy groceries").build());
        taskList.addItem(new ToDoItemBuilder().completed(true).description("Finish project").priority(Priority.HIGH).build());
        // ...
    }
}
```

## Conclusions / Screenshots / Results

By incorporating the Singleton and Builder design patterns,
we've added valuable structure and flexibility to our To-Do List
App. The Singleton ensures a single, centralized TaskList object,
preventing data duplication and simplifying task management. This
aligns with the app's purpose of maintaining a unified collection
of to-do items. The Builder pattern empowers flexible task creation
by separating property configuration from object construction. This
allows for easy creation of different task types (regular, priority)
with specific properties, making the app more versatile and
user-friendly.

