package com.tmps.client;

import com.tmps.domain.models.*;

public class Main {
    public static void main(String[] args) {
        IToDoItemRepository repository = new InMemoryToDoItemRepository(); // Injectable
        UserInterface ui = new UserInterface(new TaskList(repository));

        ui.test();
    }
}