package persistence;

import domain.OrderItem;
import org.junit.jupiter.api.Test;

import static data.TestSamples.getValidOrderItem;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

class OrderItemStorageTest {

    private OrderItemStorage orderItemStorage = new OrderItemStorage();

    @Test
    public void testPersistOrderItem() {
        OrderItem order = getValidOrderItem();

        final String id = orderItemStorage.persist(order);

        assertThat(id, is(notNullValue()));

        final OrderItem loadedByOrderId = orderItemStorage.loadByItemId(id);
        assertThat(loadedByOrderId, is(equalTo(order)));
    }
}