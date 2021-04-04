package domain;

public class OrderUtils {
    public static int getOrderCost(Order order) {
        int cost = 0;
        for (OrderItem orderItem : order.getOrderItems()) {
            cost += orderItem.getCost() * orderItem.getAmount();
        }
        return cost;
    }
}
