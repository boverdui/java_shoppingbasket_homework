package Discounts;

import ShoppingBasket.Item;

import java.util.ArrayList;

public interface IDiscount {

    double calculateSavings(ArrayList<Item> items, double total);

}
