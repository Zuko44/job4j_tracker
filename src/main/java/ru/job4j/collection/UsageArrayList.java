package ru.job4j.collection;

import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Petr");
        names.add("Ivan");
        names.add("Stepan");
        for (String str : names) {
            System.out.println(str);
        }
        names.set(0, names.get(0) + " Arsentev");
        names.remove(2);
        System.out.println();
        for (String str : names) {
            System.out.println(str);
        }
    }
}
