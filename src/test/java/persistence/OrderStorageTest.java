package persistence;

import domain.Order;
import org.junit.jupiter.api.Test;

import static data.TestSamples.getTestOrder;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

class OrderStorageTest {

    private OrderStorage orderStorage = new OrderStorage();

    @Test
    public void testPersistOrder() {
        Order order = getTestOrder();

        final String id = orderStorage.persist(order);

        assertThat(id, is(notNullValue()));

        final Order loadedByOrderId = orderStorage.loadByOrderId(id);
        assertThat(loadedByOrderId, is(equalTo(order)));
    }

    @Test
    public void testLoadOrder() {
        Order order = getTestOrder();

        final String id = orderStorage.persist(order);

        final Order loadedByOrderId = orderStorage.loadByOrderId(id);
        assertThat(loadedByOrderId, is(equalTo(order)));

        final Order[] loadedByUserId = orderStorage.loadByUserId(order.getUserId());
        assertThat(loadedByUserId[0], is(equalTo(order)));
    }
}