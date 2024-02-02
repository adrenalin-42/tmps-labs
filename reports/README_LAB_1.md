# SOLID Principles


## Author: Dumitru Moraru

----

## Objectives:

- Study and understand the SOLID Principles.
- Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.
- Create a sample project that respects SOLID Principles.


## Used Principles:

- Single Responsibility Principle
- Open-Closed Principle
- Liskov Substitution Principle
- Interface Segregation Principle
- Dependency Inversion Principle


## Implementation

**1. Single Responsibility Principle (SRP):**

This principle encourages clear separation of concerns. In our
implementation, the `UserInterface` class solely handles user
interactions, while the `TaskList` class focuses on managing to-do items.

**Code Snippet:**

```java
// client/UserInterface.java
public class UserInterface {
    private TaskList taskList; // Dependency injection for SRP

    // ... Methods for handling user interactions
}

// domain/models/TaskList.java
public class TaskList {
    private List<ToDoItem> items = new ArrayList<>();

    // ... Methods for managing the collection of to-do items
}
```

**2. Open/Closed Principle (OCP):**

This principle advocates for extending behavior without modifying existing
code. We achieve this by allowing new task types to be created as
subclasses of the `ToDoItem` class.

**Code Snippet:**

```java
// domain/models/ToDoItem.java
public class ToDoItem {
    // ...
}

// domain/models/PriorityToDoItem.java (subclass)
public class PriorityToDoItem extends ToDoItem {
    private Priority priority;

    // ...
}
```

**3. Liskov Substitution Principle (LSP):**

This principle ensures subclasses can be used seamlessly in place of
their base classes. Our implementation adheres to this by ensuring all
subclasses adhere to the contract defined in the `ToDoItem` base class.

```java
// client/UserInterface.java
public class UserInterface {
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
```

**4. Interface Segregation Principle (ISP):**

This principle promotes smaller, focused interfaces instead of
monolithic one. Instead of a single `ToDoItemManager` interface,
we use separate interfaces like `ToDoItemAdder` and `ToDoItemRemover`,
reducing coupling and increasing maintainability.

**Code Snippet:**

```java
// domain/IToDoItemAdder.java
public interface IToDoItemAdder {
    void addItem(ToDoItem item);
}

// domain/IToDoItemRemover.java
public interface IToDoItemRemover {
    void removeItem(ToDoItem item);
}

// domain/models/TaskList.java (implements both interfaces)
public class TaskList implements IToDoItemAdder, IToDoItemRemover {
    // ...
}
```

**5. Dependency Inversion Principle (DIP):**

This principle suggests depending on abstractions, not concretions.
We achieve this by relying on the `ToDoItemRepository` interface
for data access and storage, allowing easy switching between
different storage mechanisms (e.g., in-memory, file-based, database).

**Code Snippet:**

```java
// domain/IToDoItemRepository.java
public interface IToDoItemRepository {
    List<ToDoItem> getAllItems();
    void saveItem(ToDoItem item);
    void removeItem(ToDoItem item);
}

// client/Main.java
public static void main(String[] args) {
    ToDoItemRepository repository = new InMemoryToDoItemRepository(); // Injectable
    UserInterface ui = new UserInterface(new TaskList(repository));
    // ...
}
```

## Conclusions / Screenshots / Results

By following these SOLID principles, we have created a more
modular, maintainable, and adaptable To-Do List App that can
easily be extended and modified in the future.

Instead of a tangled mess of code, I've ended up with a project
that's modular, adaptable, and easy to understand. Each part has a
clear responsibility, new features can be added without breaking
existing functionality, and I can easily swap out different data
storage mechanisms.

While it definitely took some extra planning and effort to stick
to these principles throughout the development process, I can already
see the payoff. My code is cleaner, more maintainable, and I'm confident
that it can easily grow and evolve as needed.