package ShoppingBasket;

public class Item {

    private String name;
    private double price;
    private int quantity;
    private Boolean bogof;

    public Item (String name, double price, int quantity, Boolean bogof) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.bogof = bogof;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public Boolean hasBogof() {
        return this.bogof;
    }

}
