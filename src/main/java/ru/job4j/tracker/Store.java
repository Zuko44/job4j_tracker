package ru.job4j.tracker;

import java.util.List;

public interface Store extends AutoCloseable {
    Item add(Item item);

    boolean replace(Integer id, Item item);

    void delete(Integer id);

    List<Item> findAll();

    List<Item> findByName(String key);

    Item findById(Integer id);
}

