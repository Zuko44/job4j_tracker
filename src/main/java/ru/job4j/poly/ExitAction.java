package ru.job4j.poly;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Tracker;

public class ExitAction implements UserAction {
    public String name() {
        return "Exit from Menu";
    }

    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
