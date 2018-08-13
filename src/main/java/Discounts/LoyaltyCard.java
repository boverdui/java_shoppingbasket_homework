package Discounts;

public class LoyaltyCard implements Discounts.IDiscount {

    private double fraction;
    private double savings;

    public LoyaltyCard (double fraction) {
        this.fraction = fraction;
    }

    @Override
    public double calculateSavings(double total) {
        savings = total * fraction;
        return savings;
    }

}
