package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .filter(t -> t.getStandard() - t.getActual() <= 3)
                .filter(t -> t.getStandard() - t.getActual() >= 0)
                .map(t -> new Label(t.getName(), t.getPrice() / 2).toString())
                .collect(Collectors.toList());
    }
}
