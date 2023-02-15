package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {

    @Test
    public void whenSortAscByName() {
        List<Item> items = Arrays.asList(
                new Item("Гриша"),
                new Item("Яша"),
                new Item("Маша"),
                new Item("2 рубля и наша")
        );
        List<Item> expected = Arrays.asList(
                new Item("2 рубля и наша"),
                new Item("Гриша"),
                new Item("Маша"),
                new Item("Яша")
        );
        items.sort(new ItemAscByName());
        assertThat(items).isEqualTo(expected);
    }

    @Test
    public void whenSortDescByName() {
        List<Item> items = Arrays.asList(
                new Item("Испания"),
                new Item("Италия"),
                new Item("Ирландия"),
                new Item("Scotland")
        );
        List<Item> expected = Arrays.asList(
                new Item("Италия"),
                new Item("Испания"),
                new Item("Ирландия"),
                new Item("Scotland")
        );
        items.sort(new ItemDescByName());
        assertThat(items).isEqualTo(expected);
    }
}