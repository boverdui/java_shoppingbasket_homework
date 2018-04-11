package Discounts;

import ShoppingBasket.Item;

import java.util.ArrayList;

public class LoyaltyCard implements Discounts.IDiscount {

    private double fraction;
    private double savings;

    public LoyaltyCard (double fraction) {
        this.fraction = fraction;
    }

    @Override
    public double calculateSavings(ArrayList<Item> items, double total) {
        savings = total * fraction;
        return savings;
    }

}
