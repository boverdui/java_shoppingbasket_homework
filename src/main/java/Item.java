import java.math.BigDecimal;

public class Item {

    private String name;
    private int price;
    private int quantity;
    private Boolean discount;

    public Item (String name, int price, int quantity, Boolean discount) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public Boolean hasDiscount() {
        return this.discount;
    }

}
