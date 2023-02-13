package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderConvertTest {
    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        Order expected = new Order("3sfe", "Dress");
        assertThat(map.get("3sfe")).isEqualTo(expected);
    }

    @Test
    public void whenDuplicateOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        orders.add(new Order("3sfe", "Shoes"));
        orders.add(new Order("3sfe", "Phone"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.size()).isEqualTo(1);
    }
}