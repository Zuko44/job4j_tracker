package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String programLang;

    public Programmer(boolean grade, int practice, String programLang) {
        super(grade, practice);
        this.programLang = programLang;
    }
}
