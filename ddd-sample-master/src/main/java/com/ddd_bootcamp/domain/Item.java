package com.ddd_bootcamp.domain;

import java.util.Objects;

public class Item {
    private Product product;
    private int quantity;

    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return quantity == item.quantity && product.equals(item.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, quantity);
    }

    @Override
    public String toString() {
        return "Item{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }

    public String getProductName() {
        return product.getName();
    }

    public int getQuantity() {
        return quantity;
    }

    public Price getProductPrice() {
        return product.getPrice();
    }
}