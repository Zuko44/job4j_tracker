package ru.job4j.inheritance;

public class Engineer extends Profession {
    private int practice;

    public Engineer(boolean grade, int practice) {
        super(grade);
        this.practice = practice;
    }
}
