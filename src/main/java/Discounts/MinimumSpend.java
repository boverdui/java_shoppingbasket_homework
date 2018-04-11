package Discounts;

import ShoppingBasket.Item;

import java.util.ArrayList;

public class MinimumSpend implements Discounts.IDiscount {

    private double fraction;
    private double threshold;
    private double total;
    private double savings;

    public MinimumSpend (double fraction, double threshold) {
        this.fraction = fraction;
        this.threshold = threshold;
    }

    @Override
    public double calculateSavings(ArrayList<Item> items, double total) {
        if (total > threshold) {
            savings = total * fraction;
        }
        return savings;
    }

}
