package ru.job4j.tracker;

public class ExitAction implements UserAction {
    public String name() {
        return "Exit from Menu";
    }

    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
