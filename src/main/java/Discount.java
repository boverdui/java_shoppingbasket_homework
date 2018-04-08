public enum Discount {

    LOYALTYCARD(2, 0),
    MINIMUMPURCHASE(10, 2000);

    private int percentage;
    private int minimumSpend;

    Discount(int percentage, int minimumSpend) {
        this.percentage = percentage;
        this.minimumSpend = minimumSpend;
    }

    public int percentage() {
        return percentage;
    }

    public int minimumSpend() {
        return minimumSpend;
    }

}
