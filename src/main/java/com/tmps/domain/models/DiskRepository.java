package com.tmps.domain.models;

import com.tmps.domain.factory.ToDoItemBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiskRepository implements IToDoItemRepository {

	private static final String STORAGE_FILE = "todo_items.csv";

	private List<IToDoItem> items = new ArrayList<>();

	public DiskRepository() {
		loadItems();
	}

	@Override
	public List<IToDoItem> getAllItems() {
		return items;
	}

	@Override
	public void saveItem(IToDoItem item) {
		items.add(item);
		saveItems();
	}

	@Override
	public void removeItem(IToDoItem item) {
		items.remove(item);
		saveItems();
	}

	private void loadItems() {
		try (BufferedReader reader = new BufferedReader(new FileReader(STORAGE_FILE))) {
			String line;
			while ((line = reader.readLine()) != null) {
				// Parse the line and create a ToDoItem object
				// (implementation depends on your ToDoItem structure)
				IToDoItem item = createToDoItemFromLine(line);
				items.add(item);
			}
		} catch (IOException e) {
			System.err.println("Error loading items from disk: " + e.getMessage());
		}
	}

	private void saveItems() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(STORAGE_FILE))) {
			for (IToDoItem item : items) {
				// Write the item's data to the file in a suitable format
				// (implementation depends on your ToDoItem structure)
				writer.write(serializeToDoItem(item));
				writer.newLine();
			}
		} catch (IOException e) {
			System.err.println("Error saving items to disk: " + e.getMessage());
		}
	}

	// Additional methods for parsing and serializing ToDoItem objects
	private IToDoItem createToDoItemFromLine(String line) {
		// Implementation depends on your ToDoItem structure
		String[] serializedInput = line.split(",");
		String entryDescription;
		boolean entryCompleted;
		Priority priorityLevel = null;
		if (serializedInput.length == 3 || serializedInput.length == 2) {
			entryDescription = serializedInput[0];

			// DeSerialize the state of completeness
			if (serializedInput[1].equals("1")) {
				entryCompleted = true;
			} else if (serializedInput[1].equals("0")) {
				entryCompleted = false;
			} else {
				throw new RuntimeException("Invalid format");
			}
			if (serializedInput.length == 3) {
				// DeSerialize the state of completeness
				if (serializedInput[2].equals("HIGH")) {
					priorityLevel = Priority.HIGH;
				} else if (serializedInput[2].equals("LOW")) {
					priorityLevel = Priority.LOW;
				}
			}
			return new ToDoItemBuilder().description(entryDescription).completed(entryCompleted).priority(priorityLevel).build();
		}
		throw new RuntimeException("Cannot create an object");
	}

	private String serializeToDoItem(IToDoItem item) {
		// Implementation depends on your ToDoItem structure
		String output = item.getDescription() + ",";

		output += (item.isCompleted() ? "1" : "0") + ",";

		if (item.getPriority() == Priority.HIGH) {
			output += "HIGH";
		} else if (item.getPriority() == Priority.LOW) {
			output += "LOW";
		}

		return output;
	}
}
