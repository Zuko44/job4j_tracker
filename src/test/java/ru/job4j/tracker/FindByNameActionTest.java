package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindByNameActionTest {
    @Test
    public void whenItemWasFindByNameThanSuccessfully() {
        Output output = new StubOutput();
        Store memTracker = new MemTracker();
        Item item = new Item("find by name");
        memTracker.add(item);
        String findName = "find by name";
        var findAction = new FindByNameAction(output);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn(findName);

        findAction.execute(input, memTracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find items by name ===" + ln
                        + item + ln
        );
    }

    @Test
    public void whenItemWasFindByNameThanNotFound() {
        Output output = new StubOutput();
        Store memTracker = new MemTracker();
        memTracker.add(new Item("find by name"));
        String findName = "find by id";
        var findAction = new FindByNameAction(output);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn(findName);

        findAction.execute(input, memTracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find items by name ===" + ln
                        + "Заявки с именем: " + findName + " не найдены." + ln
        );
    }
}