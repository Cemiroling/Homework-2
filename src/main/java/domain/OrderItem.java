package domain;

public class OrderItem {

    private String orderId;

    private final String id;

    private final String name;

    private final int amount;

    private final int cost;

    public OrderItem(String id, String name, int amount, int cost) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.cost = cost;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public int getCost() {
        return cost;
    }
}
