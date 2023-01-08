package ru.job4j.checkstyle;

public class Broken {
    public static final String NEW_VALUE = "";
    public String surname;
    private String name;
    private int sizeOfEmpty = 10;

    public Broken() {
    }

    public void echo() {
    }

    public void media(Object obj) {
        if (obj != null) {
            System.out.println(obj);
        }
    }

    public void method(int... args) {

    }
}