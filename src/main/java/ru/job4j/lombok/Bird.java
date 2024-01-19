package ru.job4j.lombok;

import java.util.Objects;

public class Bird {
    private String color;
    private int age;
    private int wingspan;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWingspan() {
        return wingspan;
    }

    public void setWingspan(int wingspan) {
        this.wingspan = wingspan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bird bird = (Bird) o;
        return age == bird.age
                && wingspan == bird.wingspan
                && Objects.equals(color, bird.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, age, wingspan);
    }

    @Override
    public String toString() {
        return "Bird{"
                + "color='" + color + '\''
                + ", age=" + age
                + ", wingspan=" + wingspan
                + '}';
    }
}
