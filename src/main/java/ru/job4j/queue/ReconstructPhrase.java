package ru.job4j.queue;

import java.util.Deque;
import java.util.Iterator;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder newStr = new StringBuilder();
        int count = evenElements.size();
        for (int i = 0; i < count; i++) {
            Character ch = evenElements.poll();
            if (i % 2 == 0) {
                newStr.append(ch);
            }
        }
        return newStr.toString();
    }

    private String getDescendingElements() {
        StringBuilder newStr = new StringBuilder();
        Iterator<Character> iterator = descendingElements.descendingIterator();
        while (iterator.hasNext()) {
            newStr.append(iterator.next());
        }
        return newStr.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
