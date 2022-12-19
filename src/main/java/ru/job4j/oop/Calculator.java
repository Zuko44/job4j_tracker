package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int num) {
        return num - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int num) {
        return num / x;
    }

    public int sumAllOperation(int num) {
        return minus(num) + multiply(num) + divide(num) + sum(num);
    }

    public static void main(String[] args) {
        System.out.println(sum(2));
        System.out.println(minus(2));
        Calculator calculator = new Calculator();
        System.out.println(calculator.multiply(10));
        System.out.println(calculator.divide(20));
        System.out.println(calculator.sumAllOperation(5));
    }
}
