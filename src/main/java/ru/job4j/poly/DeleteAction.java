package ru.job4j.poly;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Tracker;

public class DeleteAction implements UserAction {
    public String name() {
        return "Delete item";
    }

    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
        int id = input.askInt("Enter id: ");
        if (tracker.delete(id)) {
            System.out.println("Заявка удалена успешно.");
        } else {
            System.out.println("Ошибка удаления заявки.");
        }
        return true;
    }
}
