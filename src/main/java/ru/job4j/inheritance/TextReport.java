package ru.job4j.inheritance;

public class TextReport {
    public String generated(String name, String body) {
        return name + System.lineSeparator() + body;
    }
}
