package service;

import domain.Order;
import domain.OrderStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import persistence.OrderStorage;

import java.util.UUID;

import static data.TestSamples.getTestOrder;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

class OrderServiceTest {

    private OrderService orderService;

    @Mock
    private OrderValidator orderValidator;

    @Mock
    private OrderStorage orderStorage;

    @BeforeEach
    public void before() {
        MockitoAnnotations.initMocks(this);
        when(orderStorage.persist(any())).thenReturn(UUID.randomUUID().toString());
        orderService = new OrderService(orderStorage, orderValidator);
    }

    @Test
    void createOrder() {
        Order order = getTestOrder();

        when(orderValidator.validate(order)).thenReturn(true);

        final String id = orderService.placeOrder(order);
        assertThat(id, is(notNullValue()));

        verify(orderStorage).persist(order);
        assertThat(order.getOrderStatus(), is(OrderStatus.WAITING));
    }

    @Test
    void createInvalidOrder() {
        Order order = getTestOrder();

        when(orderValidator.validate(order)).thenReturn(false);

        assertThrows(IllegalArgumentException.class, () -> orderService.placeOrder(order));
        verify(orderStorage, never()).persist(any());
    }

    @Test
    void loadAllOrdersByUserId() {
        Order order = getTestOrder();

        when(orderValidator.validate(order)).thenReturn(true);
        Order[] orders = {order};
        when(orderStorage.loadByUserId(order.getUserId())).thenReturn(orders);

        assertThat(order, is(equalTo(orderService.loadAllOrdersByUserId(order.getUserId())[0])));
    }

    @Test
    void loadAllOrdersByInvalidUserId() {
        assertThrows(IllegalArgumentException.class, () -> orderService.loadAllOrdersByUserId(null));
        verify(orderStorage, never()).loadByUserId(any());
    }
}