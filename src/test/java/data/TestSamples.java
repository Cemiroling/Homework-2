package data;

import domain.Order;
import domain.OrderItem;

public class TestSamples {
    public static Order getTestOrder() {
        OrderItem[] orderItems = {
                new OrderItem("firstId", "firstName", 2, 20),
                new OrderItem("secondId", "secondName", 3, 30)
        };
        Order order = new Order("testUserId", orderItems, "Test st.");
        return order;
    }

    public static OrderItem getValidOrderItem() {
        OrderItem orderItem = new OrderItem("firstId", "firstName", 2, 20);
        return orderItem;
    }
}
