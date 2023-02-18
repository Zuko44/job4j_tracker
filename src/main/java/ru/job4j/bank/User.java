package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс представляет собой модель данных
 * пользователя банковского сервиса
 *
 * @author Zuko44
 * @version 1.0
 */
public class User {
    /**
     * строка passport содержит документ пользователя
     */
    private String passport;
    /**
     * строка username содержит имя/инициалы пользователя
     */
    private String username;

    /**
     * конструктор задаёт базовые данные пользователя
     * при объявлении объекта
     *
     * @param passport строка passport содержит документ пользователя
     * @param username строка username содержит имя/инициалы пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * метод возвращает строку passport
     *
     * @return возвращает строку passport
     */
    public String getPassport() {
        return passport;
    }

    /**
     * метод устанавливает данные для строки passport
     *
     * @param passport возвращает строку passport с новыми данными
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * метод возвращает строку username
     *
     * @return возвращает строку username
     */
    public String getUsername() {
        return username;
    }

    /**
     * метод устанавливает данные для строки username
     *
     * @param username возвращает строку username с новыми данными
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Метод переопределяет метод equals класса Object
     *
     * @param o принимаемый объект
     * @return возвращает булевое значение сравнения переданного объекта по строке passport
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Метод переопределяет метод hashCode класса Object
     *
     * @return возвращает числовое значение фиксированной длины для любого объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
