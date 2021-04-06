package persistence;

import domain.Order;
import domain.OrderItem;

public class OrderItemStorage {
    public String persist(OrderItem orderItem) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    public String[] persistOrderItems(Order order) {
        for (OrderItem orderItem : order.getOrderItems()) {
            orderItem.setOrderId(order.getId());
            this.persist(orderItem);
        }
        throw new UnsupportedOperationException("not implemented yet");
    }

    public OrderItem loadByItemId(String itemId) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    public OrderItem[] loadByOrderId(String orderId) {
        throw new UnsupportedOperationException("not implemented yet");
    }
}
