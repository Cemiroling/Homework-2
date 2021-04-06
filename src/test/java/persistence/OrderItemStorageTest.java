package persistence;

import domain.Order;
import domain.OrderItem;
import org.hamcrest.number.OrderingComparison;
import org.junit.jupiter.api.Test;

import static data.TestSamples.getTestOrder;
import static data.TestSamples.getValidOrderItem;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

class OrderItemStorageTest {

    private OrderItemStorage orderItemStorage = new OrderItemStorage();

    @Test
    public void persist() {
        OrderItem orderItem = getValidOrderItem();

        final String id = orderItemStorage.persist(orderItem);

        assertThat(id, is(notNullValue()));

        final OrderItem loadedByOrderId = orderItemStorage.loadByItemId(id);
        assertThat(loadedByOrderId, is(equalTo(orderItem)));
    }

    @Test
    public void persistOrderItems() {
        Order order = getTestOrder();

        final String[] id = orderItemStorage.persistOrderItems(order);

        assertThat(id, is(notNullValue()));

        final OrderItem[] loadedByOrderId = orderItemStorage.loadByOrderId(order.getId());
        assertThat(loadedByOrderId, is(equalTo(order.getOrderItems())));
    }

}