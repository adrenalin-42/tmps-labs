package com.tmps.client;

import com.tmps.domain.models.*;

public class Main {
    public static void main(String[] args) {
        IToDoItemRepository repository = new InMemoryToDoItemRepository(); // Injectable
        TaskList taskList = TaskList.getInstance(repository);
        UserInterface ui = new UserInterface(taskList);

        ui.test();
    }
}