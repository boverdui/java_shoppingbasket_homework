import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {

    ArrayList<Item> items;
    Boolean loyaltycard;

    public ShoppingBasket(Boolean loyaltycard) {
        this.items = new ArrayList();
        this.loyaltycard = loyaltycard;
    }

    public boolean hasLoyaltyCard() {
        return this.loyaltycard;
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void empty() {
        items.clear();
    }

    public int getTotalCost() {
        int totalCost = 0;
        for (Item item : items) {
            totalCost += (item.getPrice() * item.getQuantity());
            if (item.hasDiscount() == true && item.getQuantity() > 2) {
                totalCost -= item.getPrice() * (item.getQuantity() / 2);
            }
        }
        if (totalCost > 2000) {
            totalCost -= totalCost * 0.1;
        }
        if (this.loyaltycard == true) {
            totalCost -= totalCost * 0.02;
        }
        return totalCost;
    }

}
