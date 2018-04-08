import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ShoppingBasketTest {

    ShoppingBasket shoppingBasket1, shoppingBasket2;
    Item ball, lanyard, waterbottle, mug;

    @Before
    public void before() {
        shoppingBasket1 = new ShoppingBasket(false);
        shoppingBasket2 = new ShoppingBasket(true);
        ball = new Item("Scotland Rugby Ball", 2500, 1, false);
        lanyard = new Item("Scotland lanyard", 375, 3, false);
        waterbottle = new Item("Scotland waterbottle", 500, 3, true);
        mug = new Item("Scotland Mug", 900, 5, true);
    }

    @Test
    public void hasLoyaltyCard() {
        assertEquals(false, shoppingBasket1.hasLoyaltyCard());
    }

    @Test
    public void shoppingBasketStartsEmpty() {
        assertEquals(Arrays.asList(), shoppingBasket1.getItems());
    }

    @Test
    public void canAddItemToShoppingBasket() {
        shoppingBasket1.addItem(ball);
        assertEquals(Arrays.asList(ball), shoppingBasket1.getItems());
    }

    @Test
    public void canRemoveItemFromShoppingbasket() {
        shoppingBasket1.addItem(ball);
        shoppingBasket1.addItem(lanyard);
        shoppingBasket1.removeItem(ball);
        assertEquals(Arrays.asList(lanyard), shoppingBasket1.getItems());
    }

    @Test
    public void canEmptyShoppingbasket() {
        shoppingBasket1.addItem(ball);
        shoppingBasket1.addItem(lanyard);
        shoppingBasket1.empty();
        assertEquals(Arrays.asList(), shoppingBasket1.getItems());
    }

    @Test
    public void canGetTotalCostWithoutDiscounts() {
        shoppingBasket1.addItem(lanyard);
        assertEquals(1125, shoppingBasket1.getTotalCost());
    }

    @Test
    public void canGetTotalCostWithLoyaltyCard() {
        shoppingBasket2.addItem(lanyard);
        assertEquals(1102, shoppingBasket2.getTotalCost());
    }

    @Test
    public void canGetTotalCostWithMinimumPurchase() {
        shoppingBasket1.addItem(ball);
        assertEquals(2250, shoppingBasket1.getTotalCost());
    }

    @Test
    public void canGetTotalCostWithBOGOF() {
        shoppingBasket1.addItem(waterbottle);
        assertEquals(1000, shoppingBasket1.getTotalCost());
    }

    @Test
    public void canGetTotalCostWithLoyaltyCardAndMinimumPurchase() {
        shoppingBasket2.addItem(ball);
        assertEquals(2205, shoppingBasket2.getTotalCost());
    }

    @Test
    public void canGetTotalCostWithLoyaltyCardAndBOGOF() {
        shoppingBasket2.addItem(waterbottle);
        assertEquals(980, shoppingBasket2.getTotalCost());
    }

    @Test
    public void canGetTotalCostWithMinimumPurchaseAndBOGOF() {
        shoppingBasket1.addItem(mug);
        assertEquals(2430, shoppingBasket1.getTotalCost());
    }

    @Test
    public void canGetTotalCostWithLoyaltyCardAndMinimumPurchaseAndBOGOF() {
        shoppingBasket2.addItem(mug);
        assertEquals(2381, shoppingBasket2.getTotalCost());
    }

    @Test
    public void multipleItemsWithVariousDiscounts1() {
        shoppingBasket1.addItem(ball);
        shoppingBasket1.addItem(lanyard);
        shoppingBasket1.addItem(waterbottle);
        shoppingBasket1.addItem(mug);
        assertEquals(6592, shoppingBasket1.getTotalCost());
    }

    @Test
    public void multipleItemsWithVariousDiscounts2() {
        shoppingBasket2.addItem(ball);
        shoppingBasket2.addItem(lanyard);
        shoppingBasket2.addItem(waterbottle);
        shoppingBasket2.addItem(mug);
        assertEquals(6460, shoppingBasket2.getTotalCost());
    }

}
