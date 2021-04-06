package data;

import domain.Order;
import domain.OrderItem;

public class TestSamples {
    public static Order getTestOrder() {
        OrderItem[] orderItems = {
                getValidOrderItem()
        };
        Order order = new Order("testUserId", orderItems, "Test st.");
        return order;
    }

    public static OrderItem getValidOrderItem() {
        OrderItem orderItem = new OrderItem("firstId", "firstName", 2, 20);
        return orderItem;
    }
}
