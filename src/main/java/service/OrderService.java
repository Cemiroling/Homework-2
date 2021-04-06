package service;

import domain.Order;
import domain.OrderItem;
import domain.OrderStatus;
import persistence.OrderItemStorage;
import persistence.OrderStorage;

import java.util.Date;

public class OrderService {

    private final OrderStorage orderStorage;

    private final OrderItemStorage orderItemStorage;

    private final OrderValidator orderValidator;

    public OrderService(OrderStorage orderStorage, OrderItemStorage orderItemStorage, OrderValidator orderValidator) {
        this.orderStorage = orderStorage;
        this.orderItemStorage = orderItemStorage;
        this.orderValidator = orderValidator;
    }

    public String placeOrder(Order order) {
        boolean valid = orderValidator.validate(order);
        if (!valid) {
            throw new IllegalArgumentException("Order is not valid " + order);
        }

        order.setOrderStatus(OrderStatus.WAITING);
        order.setOrderDate(new Date());

        final String id = orderStorage.persist(order);
        order.setId(id);
        orderItemStorage.persistOrderItems(order);

        return id;
    }

    public Order[] loadAllOrdersByUserId(String userId) {
        if (userId == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        Order[] orders = orderStorage.loadByUserId(userId);

        for (Order order : orders) {
            OrderItem[] orderItems = orderItemStorage.loadByOrderId(order.getId());
            order.setOrderItems(orderItems);
        }

        return orders;
    }
}