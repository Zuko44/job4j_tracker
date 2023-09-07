package ru.job4j.tracker;

public class ExitAction implements UserAction {
    private final Output out;

    public ExitAction(Output out) {
        this.out = out;
    }

    public String name() {
        return "Exit from Menu";
    }

    public boolean execute(Input input, Store memTracker) {
        out.println("Exit");
        return false;
    }
}
