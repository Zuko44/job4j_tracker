package ru.job4j.inheritance;

public class JSONReport extends TextReport {
    @Override
    public String generated(String name, String body) {
        return "{" + System.lineSeparator()
             + "\t\"name\"" + " : " + "\"" + name + "\"" + "," + System.lineSeparator()
                + "\t\"body\"" + " : " + "\"" + body + "\"" + System.lineSeparator() + "}";
    }
}
