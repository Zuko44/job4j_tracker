package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student old = new Student();
        old.setInitials("Kronin Vlad");
        old.setGroup("Intern");
        old.setStarted(new Date());

        System.out.println(old.getInitials());
        System.out.println(old.getGroup());
        System.out.println(old.getStarted());
    }
}
