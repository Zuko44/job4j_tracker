package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println("The bus is coming");
    }

    @Override
    public void passengers(int pass) {
        System.out.println("The passengers - " + pass);
    }

    @Override
    public int refuel(int fuel) {
        return fuel * 53;
    }
}
