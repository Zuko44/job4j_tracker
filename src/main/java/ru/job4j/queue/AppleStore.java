package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        if (queue.poll() != null) {
            for (int i = 0; i < count; i++) {
                if (i == count - 2) {
                    break;
                }
                queue.poll();
            }
        }
        return queue.poll().name();
    }

    public String getFirstUpsetCustomer() {
        if (queue.poll() != null) {
            for (int i = 0; i <= count; i++) {
                if (i == count - 1) {
                    break;
                }
                queue.poll();
            }
        }
        return queue.poll().name();
    }
}
