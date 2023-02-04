package com.ddd_bootcamp.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Test
    void shouldAddProductToCart() {
        Cart cart = new Cart();
        Price price = new Price(new BigDecimal(11), Currency.getInstance("USD"));
        Product product = new Product("Some test product", price);
        cart.add(new Item(product, 1));

        List<Item> actual = cart.getItems();

        assertEquals(1, actual.size());
        assertEquals("Some test product", actual.get(0).getProductName());

    }
}