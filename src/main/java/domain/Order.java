package domain;

import java.util.Date;

public class Order {

    private String id;

    private final String userId;

    private Date orderDate;

    private OrderStatus orderStatus;

    private final OrderItem[] orderItems;

    private final String address;

    private int cost;

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
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
