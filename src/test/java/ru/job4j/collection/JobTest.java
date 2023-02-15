package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorAscByName() {
        Comparator<Job> ascName = new JobAscByName();
        int rsl = ascName.compare(
                new Job("Adolf", 1),
                new Job("Gitler", 2)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorAscByPriority() {
        Comparator<Job> ascPriority = new JobAscByPriority();
        int rsl = ascPriority.compare(
                new Job("Johann", 1),
                new Job("Mendel", 2)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComapatorDescByName() {
        Comparator<Job> descName = new JobDescByName();
        int rsl = descName.compare(
                new Job("Johann", 1),
                new Job("Mendel", 2)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComapatorDescByPriority() {
        Comparator<Job> descPriority = new JobDescByPriority();
        int rsl = descPriority.compare(
                new Job("Johann", 1),
                new Job("Mendel", 2)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComapatorAscByPriorityAndAscByName() {
        Comparator<Job> ascByPriorityAndName = new JobAscByPriority().thenComparing(new JobAscByName());
        int rsl = ascByPriorityAndName.compare(
                new Job("Fix bug", 1),
                new Job("Fix bug", 4)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComapatorDescByPriorityAndDescByName() {
        Comparator<Job> descByPriorityAndName = new JobDescByPriority().thenComparing(new JobDescByName());
        int rsl = descByPriorityAndName.compare(
                new Job("Fix bug", 1),
                new Job("Fix bug", 4)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}