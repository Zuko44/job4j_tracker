package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] rsl = new Item[size];
        int count = 0;
        for (int index = 0; index < size; index++) {
            Item elem = items[index];
            if (elem != null) {
                rsl[count++] = elem;
            }
        }
        rsl = Arrays.copyOf(rsl, count);
        return rsl;
    }

    public Item[] findByName(String key) {
        Item[] arr = new Item[size];
        int count = 0;
        for (int index = 0; index < size; index++) {
            Item elem = items[index];
            if (key.equals(elem.getName())) {
                arr[count++] = elem;
            }
        }
        arr = Arrays.copyOf(arr, count);
        return arr;
    }
}