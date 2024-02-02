# Behavioral Design Patterns


## Author: Dumitru Moraru

----

## Objectives:
- Study and understand the Behavioral Design Patterns.
- As a continuation of the previous laboratory work, think
about what communication between software entities might be
involed in your system.
- Create a new Project or add some additional functionalities
using behavioral design patterns.

# Theory

Behavioral design patterns are a category of design patterns that 
focus on the interaction and communication between objects and 
classes. They provide a way to organize the behavior of objects 
in a way that is both flexible and reusable, while separating the 
responsibilities of objects from the specific implementation 
details. Behavioral design patterns address common problems 
encountered in object behavior, such as how to define interactions 
between objects, how to control the flow of messages between objects, 
or how to define algorithms and policies that can be reused across 
different objects and classes.

Some examples from this category of design patterns are :
- Chain of Responsibility
- Command
- Interpreter
- Iterator
- Mediator
- Observer
- Strategy

## Used Design Patterns:
- Iterator


## Implementation
**Decorator Pattern:**
- Marking tasks as `Urgent` by wrapping them with a `UrgentTaskDecorator`, 
displaying urgency indicators and potentially sending reminders.
Adds new functionalities to existing tasks without modifying 
their core structure.
- Code snippet:
## Filtering To-Do Tasks with the Iterator Pattern

To offer dynamic task filtering in my To-Do List App, I embraced the Iterator Pattern. This powerful design pattern enables me to iterate over tasks without directly accessing the underlying collection, promoting maintainability and flexibility.

Here's how it works:

1. **TaskIterator interface:** Defines the basic contract for iterating over tasks, ensuring uniformity regardless of specific filtering criteria.

```java
// Base iterator interface
public interface ITaskIterator {
    boolean hasNext();
    IToDoItem next();
}
```

2. **Concrete iterators:** Implementations like `PriorityTaskIterator` cater to specific filtering needs. This one iterates over all tasks, returning only those matching the desired priority.

```java
// Concrete iterator for filtering tasks by priority
public class PriorityTaskIterator implements ITaskIterator {
    // ... implementation for filtering and iterating
}
```

3. **Usage:** Client code iterates over filtered tasks using the appropriate iterator, achieving targeted views without modifying the core task collection.

```java
public void view_highpriority() {
    ITaskIterator priorityTasks = new PriorityTaskIterator(taskList.getItems(), Priority.HIGH);
    while (priorityTasks.hasNext()) {
        IToDoItem task = priorityTasks.next();
        System.out.println("High priority task: " + task.getDescription());
    }
}
```

## Conclusions / Screenshots / Results

Looking back, implementing the Iterator Pattern for task filtering
in my To-Do List App was a wise decision. It provided 
**clean separation** between task iteration logic and the actual task 
collection, allowing for **flexible filtering mechanisms** without 
touching the core data structure. This promotes **maintainability 
and reduces code complexity**, especially as new filtering criteria 
are added. The use of iterators directly reflects the **real-world 
concept of filtering** and makes the code easier to understand and 
reason about. In essence, the Iterator Pattern offered a **modular 
and adaptable solution** for managing task views based on different
needs, making my To-Do List App more versatile and user-friendly. So,
to fellow developers struggling with data iteration and filtering, I 
say: don't underestimate the power of the Iterator Pattern! It can be
a valuable tool to keep your code organized and adaptable in the face
of changing requirements.