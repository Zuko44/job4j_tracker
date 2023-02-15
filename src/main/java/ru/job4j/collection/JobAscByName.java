package ru.job4j.collection;

import java.util.Comparator;

public class JobAscByName implements Comparator<Job> {
    public int compare(Job first, Job second) {
        return first.getName().compareTo(second.getName());
    }
}
