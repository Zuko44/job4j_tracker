package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    public String name() {
        return "Find by name item";
    }

    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ===");
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item elem : items) {
                System.out.println(elem);
            }
        } else {
            System.out.println("Заявки с именем: " + name + " не найдены.");
        }
        return true;
    }
}
