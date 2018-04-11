package Discounts;

import ShoppingBasket.Item;

import java.util.ArrayList;

public class Bogof implements Discounts.IDiscount {

    public Bogof () {
    }

    @Override
    public double calculateSavings(ArrayList<Item> items, double total) {
        double savings = 0;
        for (Item item : items) {
            if (item.hasBogof()) {
                savings += item.getPrice() * (item.getQuantity() / 2);
            }
        }
        return savings;
    }

}
