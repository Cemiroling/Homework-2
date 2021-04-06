package domain;

import java.util.Date;

public class Order {

    private String id;

    private OrderStatus orderStatus;

    private final String userId;

    private Date orderDate;

    private OrderItem[] orderItems;

    private final String address;

    public Order(String userId, OrderItem[] orderItems, String address) {
        this.userId = userId;
        this.orderItems = orderItems;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public OrderItem[] getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(OrderItem[] orderItems) {
        this.orderItems = orderItems;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getAddress() {
        return address;
    }

    public int getCost() {
        int cost = 0;
        for (OrderItem orderItem : getOrderItems()) {
            cost += orderItem.getCost() * orderItem.getAmount();
        }
        return cost;
    }
}