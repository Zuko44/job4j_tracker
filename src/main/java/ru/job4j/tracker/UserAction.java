package ru.job4j.tracker;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Tracker;

public interface UserAction {
    String name();

    boolean execute(Input input, Tracker tracker);
}
