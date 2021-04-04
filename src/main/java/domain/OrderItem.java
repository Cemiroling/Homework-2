package domain;

public class OrderItem {

    private final String id;

    private String name;

    private int amount;

    private int cost;

    public OrderItem(String id, String name, int amount, int cost) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
