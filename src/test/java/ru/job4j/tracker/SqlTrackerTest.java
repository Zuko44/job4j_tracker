package ru.job4j.tracker;

import org.junit.jupiter.api.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;
@Disabled
/** Тесты отключены, вроде как, но бот все равно упадёт */
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
        try (PreparedStatement statement = connection.prepareStatement("delete from ITEMS")) {
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
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replace.getName());
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
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("pipka");
        Item second = new Item("pupka");
        tracker.add(item);
        tracker.add(second);
        assertThat(tracker.findAll().size()).isEqualTo(2);
    }

    @Test
    void whenFindByNameItemsAndThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("pipka");
        Item item2 = new Item("pipka");
        tracker.add(item);
        tracker.add(item2);
        assertThat(tracker.findByName("pipka").size()).isEqualTo(2);
    }

    @Test
    void whenFindByIdItemsAndThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("pipka");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }
}
