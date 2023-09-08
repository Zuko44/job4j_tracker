package ru.job4j.tracker;

import java.util.Objects;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    public String name() {
        return "Delete item";
    }

    /**public boolean execute(Input input, Store memTracker) {
        out.println("=== Delete item ===");
        int id = input.askInt("Enter id: ");
        if (memTracker.delete(id)) {
            out.println("Заявка удалена успешно.");
        } else {
            out.println("Ошибка удаления заявки.");
        }
        return true;
    }*/
    public boolean execute(Input input, Store memTracker) {
        out.println("=== Delete item ===");
        int id = input.askInt("Enter id: ");
        memTracker.delete(id);
        if (memTracker.findById(id).getId() == 0) {
            out.println("Заявка удалена успешно.");
        } else {
            System.out.println(memTracker.findById(id));
            out.println("Ошибка удаления заявки.");
        }
        return true;
    }
}
