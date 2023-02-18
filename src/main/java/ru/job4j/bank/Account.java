package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс представляет собой модель данных
 * аккаунта пользователя банковского сервиса
 *
 * @author Zuko44
 * @version 1.0
 */
public class Account {
    /**
     * строка requisite содержит реквизиты пользователя
     */
    private String requisite;
    /**
     * строка balance содержит баланс средств на счёте пользователя
     */
    private double balance;

    /**
     * конструктор задаёт базовые данные аккаунта пользователя
     * при объявлении объекта
     *
     * @param requisite строка requisite содержит реквизиты пользователя
     * @param balance   строка balance содержит баланс средств на счёте пользователя
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * метод возвращает строку requisite
     *
     * @return возвращает строку requisite
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * метод устанавливает данные для строки requisite
     *
     * @param requisite возвращает строку requisite с новыми данными
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * метод возвращает строку balance
     *
     * @return возвращает строку balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * метод устанавливает данные для строки balance
     *
     * @param balance возвращает строку balance с новыми данными
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Метод переопределяет метод equals класса Object
     *
     * @param o принимаемый объект
     * @return возвращает булевое значение сравнения переданного объекта по строке requisite
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Метод переопределяет метод hashCode класса Object
     *
     * @return возвращает числовое значение фиксированной длины для любого объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
