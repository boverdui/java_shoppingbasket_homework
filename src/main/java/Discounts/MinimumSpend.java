package Discounts;

public class MinimumSpend implements Discounts.IDiscount {

    private double fraction;
    private double threshold;
    private double savings;

    public MinimumSpend (double fraction, double threshold) {
        this.fraction = fraction;
        this.threshold = threshold;
    }

    @Override
    public double calculateSavings(double total) {
        if (total > threshold) {
            savings = total * fraction;
        }
        return savings;
    }

}
