import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {

    Item ball;

    @Before
    public void before() {
        ball = new Item("Scotland Rugby Ball", 2500, 1, false);
    }

    @Test
    public void hasName() {
        assertEquals("Scotland Rugby Ball", ball.getName());
    }

    @Test
    public void hasPrice() {
        assertEquals(2500, ball.getPrice());
    }

    @Test
    public void hasQuantity() {
        assertEquals(1, ball.getQuantity());
    }

    @Test
    public void hasDiscount() {
        assertEquals(false, ball.hasDiscount());
    }

}
