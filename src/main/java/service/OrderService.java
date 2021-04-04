package service;

import domain.Order;
import domain.OrderStatus;
import persistence.OrderStorage;

import java.util.Date;

import static domain.OrderUtils.getOrderCost;

public class OrderService {

    private final OrderStorage orderStorage;

    private final OrderValidator orderValidator;

    public OrderService(OrderStorage orderStorage, OrderValidator orderValidator) {
        this.orderStorage = orderStorage;
        this.orderValidator = orderValidator;
    }

    public String placeOrder(Order order) {
        boolean valid = orderValidator.validate(order);
        if (!valid) {
            throw new IllegalArgumentException("Order is not valid " + order);
        }

        order.setOrderStatus(OrderStatus.WAITING);
        order.setOrderDate(new Date());

        int orderCost = getOrderCost(order);
        order.setCost(orderCost);

        final String id = orderStorage.persist(order);
        order.setId(id);

        return id;
    }

    public Order[] loadAllOrdersByUserId(String userId) {
        if (userId == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        Order[] orders = orderStorage.loadByUserId(userId);
        return orders;
    }
}
