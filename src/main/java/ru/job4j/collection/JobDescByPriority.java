package ru.job4j.collection;

import java.util.Comparator;

public class JobDescByPriority implements Comparator<Job> {
    public int compare(Job first, Job second) {
        return  Integer.compare(second.getPriority(), first.getPriority());
    }
}
