package ShoppingBasket;

import Discounts.IDiscount;

import java.util.ArrayList;

public class ShoppingBasket {

    ArrayList<Item> items;
    ArrayList<IDiscount> discounts;

    public ShoppingBasket() {
        this.items = new ArrayList<Item>();
        this.discounts = new ArrayList<IDiscount>();
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public void empty() {
        this.items.clear();
    }

    public ArrayList<IDiscount> getDiscounts() {
        return this.discounts;
    }

    public void applyDiscount(IDiscount discount) {
        this.discounts.add(discount);
    }

    public double getTotal() {
        double total = 0;
        for (Item item : this.items) {
            total += (item.getPrice() * item.getQuantity());
        }
        for (IDiscount discount : this.discounts) {
            double savings = discount.calculateSavings(this.items, total);
            total -= savings;
        }
        return total;
    }

}
