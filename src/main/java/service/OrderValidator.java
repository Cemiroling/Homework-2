package service;

import domain.Order;

public class OrderValidator {
    public boolean validate(Order order) {
        if (order.getUserId() == null) {
            return false;
        }

        if (order.getOrderItems() == null) {
            return false;
        }

        if (order.getAddress() == null) {
            return false;
        }

        return true;
    }
}
