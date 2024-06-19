package cyclechronicles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ShopTest {

    Order order;
    Shop shop = new Shop();

    @BeforeEach
    public void setup() {
        order = mock(Order.class);
    }

    @Test
    void testAcceptTrue() {
        when(order.getBicycleType()).thenReturn(Type.RACE);
        when(order.getCustomer()).thenReturn("Jean");
        assertTrue(shop.accept(order));
    }
    @Test
    void testAcceptFalseEBIKE() {
        when(order.getBicycleType()).thenReturn(Type.EBIKE);
        when(order.getCustomer()).thenReturn("Jean");
        assertFalse(shop.accept(order));
    }
    @Test
    void testAcceptFalseGRAVEL() {
        when(order.getBicycleType()).thenReturn(Type.GRAVEL);
        when(order.getCustomer()).thenReturn("Jean");
        assertFalse(shop.accept(order));
    }
    @Test
    void testAcceptFalsePendingOrderCustomer() {
        when(order.getBicycleType()).thenReturn(Type.RACE);
        when(order.getCustomer()).thenReturn("Jean");
        shop.accept(order);
        assertFalse(shop.accept(order));
    }
    @Test
    void testAcceptFalsePendingOrderMax() {
        when(order.getBicycleType()).thenReturn(Type.RACE);
        when(order.getCustomer()).thenReturn("Jean");
        shop.accept(order);
        when(order.getCustomer()).thenReturn("Luc");
        shop.accept(order);
        when(order.getCustomer()).thenReturn("Picard");
        shop.accept(order);
        when(order.getCustomer()).thenReturn("William");
        shop.accept(order);
        when(order.getCustomer()).thenReturn("Ricker");
        assertFalse(shop.accept(order));
    }
    @Test
    void testAcceptFalseEBikeOrderMax() {
        when(order.getBicycleType()).thenReturn(Type.RACE);
        when(order.getCustomer()).thenReturn("Jean");
        shop.accept(order);
        when(order.getCustomer()).thenReturn("Luc");
        shop.accept(order);
        when(order.getCustomer()).thenReturn("Picard");
        shop.accept(order);
        when(order.getCustomer()).thenReturn("William");
        shop.accept(order);
        when(order.getBicycleType()).thenReturn(Type.EBIKE);
        when(order.getCustomer()).thenReturn("Ricker");
        assertFalse(shop.accept(order));
    }
    @Test
    void testAcceptFalseGBikeOrderMax() {
        when(order.getBicycleType()).thenReturn(Type.RACE);
        when(order.getCustomer()).thenReturn("Jean");
        shop.accept(order);
        when(order.getCustomer()).thenReturn("Luc");
        shop.accept(order);
        when(order.getCustomer()).thenReturn("Picard");
        shop.accept(order);
        when(order.getCustomer()).thenReturn("William");
        shop.accept(order);
        when(order.getBicycleType()).thenReturn(Type.GRAVEL);
        when(order.getCustomer()).thenReturn("Ricker");
        assertFalse(shop.accept(order));
    }
    @Test
    void testAcceptFalseCustomerPendingOrderMax() {
        when(order.getBicycleType()).thenReturn(Type.RACE);
        when(order.getCustomer()).thenReturn("Jean");
        shop.accept(order);
        when(order.getCustomer()).thenReturn("Luc");
        shop.accept(order);
        when(order.getCustomer()).thenReturn("Picard");
        shop.accept(order);
        when(order.getCustomer()).thenReturn("William");
        shop.accept(order);
        when(order.getCustomer()).thenReturn("Jean");
        assertFalse(shop.accept(order));
    }
    @Test
    void testAcceptFalseEBikeCustomerPending() {
        when(order.getBicycleType()).thenReturn(Type.RACE);
        when(order.getCustomer()).thenReturn("Jean");
        shop.accept(order);
        when(order.getBicycleType()).thenReturn(Type.EBIKE);
        assertFalse(shop.accept(order));
    }
    @Test
    void testAcceptFalseGBikeCustomerPending() {
        when(order.getBicycleType()).thenReturn(Type.RACE);
        when(order.getCustomer()).thenReturn("Jean");
        shop.accept(order);
        when(order.getBicycleType()).thenReturn(Type.GRAVEL);
        assertFalse(shop.accept(order));
    }
}
