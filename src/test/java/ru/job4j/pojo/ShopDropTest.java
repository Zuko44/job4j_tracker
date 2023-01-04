package ru.job4j.pojo;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ShopDropTest {
    @Test
    public void whenDropFirst() {
        Product[] products = new Product[2];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        Product[] rsl = ShopDrop.delete(products, 0);
        assertThat(rsl[0].getName()).isEqualTo("Bread");
        assertThat(rsl[1]).isNull();
    }

    @Test
    public void whenDropLast() {
        Product[] products = new Product[2];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        Product[] rsl = ShopDrop.delete(products, 1);
        assertThat(rsl[0].getName()).isEqualTo("Milk");
        assertThat(rsl[1]).isNull();
    }

    @Test
    public void whenArrayLengthIs4AndDeleteElementWithIndex1() {
        Product[] products = new Product[4];
        products[0] = new Product("Bread", 4);
        products[1] = new Product("Egg", 10);
        products[2] = new Product("Milk", 2);
        products[3] = new Product("Fish", 3);
        int index = 1;
        Product[] rsl = ShopDrop.delete(products, index);
        assertThat(rsl[index].getName()).isEqualTo("Milk");
        assertThat(rsl[2].getName()).isEqualTo("Fish");
        assertThat(rsl[products.length - 1]).isNull();
    }

    @Test
    public void whenArrayLengthIs5AndDeleteElementWithIndex2() {
        Product[] products = new Product[5];
        products[0] = new Product("Bread", 4);
        products[1] = new Product("Egg", 10);
        products[2] = new Product("Milk", 2);
        products[3] = new Product("Fish", 3);
        products[4] = new Product("Fruit", 8);
        int index = 2;
        Product[] rsl = ShopDrop.delete(products, index);
        assertThat(rsl[1].getName()).isEqualTo("Egg");
        assertThat(rsl[index].getName()).isEqualTo("Fish");
        assertThat(rsl[3].getName()).isEqualTo("Fruit");
        assertThat(rsl[products.length - 1]).isNull();
    }
}