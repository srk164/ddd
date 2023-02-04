package com.ddd_bootcamp.application;

import com.ddd_bootcamp.domain.Cart;
import com.ddd_bootcamp.domain.Item;
import com.ddd_bootcamp.domain.Price;
import com.ddd_bootcamp.domain.Product;
import com.ddd_bootcamp.domain.domain_service.CompetitorBasedPricer;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        //codeProblem7();

        System.out.println("-------------------------------------------------------------------");

        Price applePencilPrice = CompetitorBasedPricer.getPrice("Apple Pencil");

        System.out.println("Discounted Price for Apple Pencil: " + applePencilPrice);

        Price sonyWirelessHeadphonePrice = CompetitorBasedPricer.getPrice("Sony Wireless headphone");

        System.out.println("Discounted Price for Sony Wireless headphone: "
                + sonyWirelessHeadphonePrice);

        System.out.println("-------------------------------------------------------------------");

        Cart cart = new Cart();

        cart.add(new Item( new Product("Apple Pencil",applePencilPrice), 1));
        cart.add(new Item( new Product("Sony Wireless headphone",sonyWirelessHeadphonePrice), 1));

        System.out.println("cart = " + cart);

        //Code Problem 6
        //codeProblem6();

    }

    private static void codeProblem7() {
        Cart cart = new Cart();

        Product headphone = new Product("Sony Wireless headphone", new Price(BigDecimal.valueOf(10), Currency.getInstance("USD")));
        Item headphoneItem = new Item(headphone,1);
        cart.add(headphoneItem);

        Product applePencil = new Product("Apple Pencil", new Price(BigDecimal.valueOf(100), Currency.getInstance("USD")));
        Item applePencilItem = new Item(applePencil, 2);
        cart.add(applePencilItem);


        System.out.println("Cart = " + cart);
        List<Item> items = cart.getItems();
        System.out.println("items = " + items);
    }


    private static void codeProblem6() {
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();

        Product headphone1 = new Product("Sony Wireless headphone", new Price(BigDecimal.valueOf(10), Currency.getInstance("USD")));
        Item headphoneItem1 = new Item(headphone1,1);

        Product headphone2 = new Product("Sony Wireless headphone", new Price(BigDecimal.valueOf(10), Currency.getInstance("USD")));
        Item headphoneItem2= new Item(headphone2,1);

        cart1.add(headphoneItem1);
        cart2.add(headphoneItem2);

        System.out.println(cart1.equals(cart2)? "Carts are same" : "Carts are different");
        System.out.println(cart1.hasSameIdentityAs(cart2)? "Carts are same"  : "Carts are different");
    }
}