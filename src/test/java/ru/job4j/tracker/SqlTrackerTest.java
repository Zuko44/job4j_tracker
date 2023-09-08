package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = new FileInputStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    void whenReplaceItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        Item replace = new Item("mumu");
        tracker.replace(item.getId(), replace);
        assertThat(tracker.findById(item.getId())).isEqualTo(replace);
    }

    @Test
    void whenDeleteItemAndFindByGeneratedIdThenNull() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        tracker.delete(item.getId());
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    void whenFindAllItemsAndThenMustBeTheSame() {
        List<Item> items = new ArrayList<>();
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("pipka");
        Item second = new Item("pupka");
        tracker.add(item);
        tracker.add(second);
        items.add(item);
        items.add(second);
        assertThat(tracker.findAll()).isEqualTo(items);
    }

    @Test
    void whenFindByNameItemsAndThenMustBeTheSame() {
        List<Item> items = new ArrayList<>();
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("pipka");
        tracker.add(item);
        items.add(item);
        assertThat(tracker.findByName("pipka")).isEqualTo(items);
    }

    @Test
    void whenFindByIdItemsAndThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("pipka");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }
}