package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    public String name() {
        return "Find by id item";
    }

    public boolean execute(Input input, Store memTracker) {
        out.println("=== Find item by id ===");
        int id = input.askInt("Enter id: ");
        Item item = memTracker.findById(id);
        if (item != null) {
            out.println(item);
        } else {
            out.println("Заявка с введенным id: " + id + " не найдена.");
        }
        return true;
    }
}
