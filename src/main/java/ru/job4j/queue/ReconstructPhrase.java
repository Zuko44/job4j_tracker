package ru.job4j.queue;

import java.util.Deque;

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
        for (int i = 0; i < count; i += 2) {
            newStr.append(evenElements.poll());
            evenElements.poll();
        }
        return newStr.toString();
    }

    private String getDescendingElements() {
        StringBuilder newStr = new StringBuilder();
        int count = descendingElements.size();
        for (int i = 0; i < count; i++) {
            Character ch = descendingElements.pollLast();
            newStr.append(ch);
        }
        return newStr.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
