package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Item {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
    /**
     * private final LocalDateTime created = LocalDateTime.now();
     */
    private int id;
    private String name;
    private LocalDateTime created = LocalDateTime.now().withNano(0);
    /**  Изменено время, убраны миллисекунды */

    public Item() {

    }

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, LocalDateTime created) {
        this.name = name;
        this.created = created;
    }

    public Item(int id, String name, LocalDateTime created) {
        this.id = id;
        this.name = name;
        this.created = created;
    }

    public LocalDateTime getCreated() {
        return this.created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{"
                + "id=" + id
                + ", name='" + name
                + "', created=" + created + '\''
                + "}";
    }


    /**
     * @Override public String toString() {
     * return "Item{" + "id=" + id + ", name='" + name + '\'' + ", created=" + created.format(FORMATTER) + '}';
     * }
     */
    /** Переопределены методы */

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return id == item.id && Objects.equals(name, item.name)
                && Objects.equals(created, item.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, created);
    }
}