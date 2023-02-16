package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftResult = left.split("\\.");
        String[] rightResult = right.split("\\.");
        return Integer.compare(Integer.parseInt(leftResult[0]), Integer.parseInt(rightResult[0]));
    }
}
