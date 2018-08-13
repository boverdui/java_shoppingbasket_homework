import Discounts.IDiscount;
import Discounts.LoyaltyCard;
import Discounts.MinimumSpend;
import ShoppingBasket.Item;
import ShoppingBasket.ShoppingBasket;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ShoppingBasketTest {

    ShoppingBasket shoppingBasket;
    Item ball, lanyard, waterbottle, mug;
    IDiscount minimumSpend, loyaltyCard;

    @Before
    public void before() {
        shoppingBasket = new ShoppingBasket();
        ball = new Item("Scotland Rugby Ball", 25.00, 1, false);
        lanyard = new Item("Scotland lanyard", 3.75, 3, false);
        waterbottle = new Item("Scotland waterbottle", 5.00, 3, true);
        mug = new Item("Scotland Mug", 9.00, 5, true);
        minimumSpend = new MinimumSpend(0.1, 20.00);
        loyaltyCard = new LoyaltyCard(0.02);
    }


    @Test
    public void shoppingBasketStartsEmpty() {
        assertEquals(Arrays.asList(), shoppingBasket.getItems());
    }

    @Test
    public void canAddItemToShoppingBasket() {
        shoppingBasket.addItem(ball);
        assertEquals(Arrays.asList(ball), shoppingBasket.getItems());
    }

    @Test
    public void canRemoveItemFromShoppingBasket() {
        shoppingBasket.addItem(ball);
        shoppingBasket.addItem(lanyard);
        shoppingBasket.removeItem(ball);
        assertEquals(Arrays.asList(lanyard), shoppingBasket.getItems());
    }

    @Test
    public void canEmptyShoppingBasket() {
        shoppingBasket.addItem(ball);
        shoppingBasket.addItem(lanyard);
        shoppingBasket.empty();
        assertEquals(Arrays.asList(), shoppingBasket.getItems());
    }

    @Test
    public void canApplyDiscountToShoppingBasket() {
        shoppingBasket.applyDiscount(minimumSpend);
        assertEquals(Arrays.asList(minimumSpend), shoppingBasket.getDiscounts());
    }

    @Test
    public void canGetTotalWithBogof() {
        shoppingBasket.addItem(ball);
        shoppingBasket.addItem(lanyard);
        shoppingBasket.addItem(waterbottle);
        shoppingBasket.addItem(mug);
        assertEquals(73.25, shoppingBasket.calculateTotal(), 0.01);
    }

    @Test
    public void canGetTotalWithBogofAndMinimumSpendDiscount() {
        shoppingBasket.addItem(ball);
        shoppingBasket.addItem(lanyard);
        shoppingBasket.addItem(waterbottle);
        shoppingBasket.addItem(mug);
        shoppingBasket.applyDiscount(minimumSpend);
        assertEquals(65.93, shoppingBasket.calculateTotal(), 0.01);
    }

    @Test
    public void canCalculateTotalWithBogofAndLoyaltyCardDiscount() {
        shoppingBasket.addItem(ball);
        shoppingBasket.addItem(lanyard);
        shoppingBasket.addItem(waterbottle);
        shoppingBasket.addItem(mug);
        shoppingBasket.applyDiscount(loyaltyCard);
        assertEquals(71.79, shoppingBasket.calculateTotal(), 0.01);
    }

    @Test
    public void canCalculateTotalWithAllDiscounts() {
        shoppingBasket.addItem(ball);
        shoppingBasket.addItem(lanyard);
        shoppingBasket.addItem(waterbottle);
        shoppingBasket.addItem(mug);
        shoppingBasket.applyDiscount(minimumSpend);
        shoppingBasket.applyDiscount(loyaltyCard);
        assertEquals(64.61, shoppingBasket.calculateTotal(), 0.01);
    }

}
