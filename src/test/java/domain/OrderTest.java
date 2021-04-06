package domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class OrderTest {

    @Test
    void getCost() {
        Order order = new Order("userTestId",
                new OrderItem[]{new OrderItem("itemId", "testName", 10, 10)},
                "testAddress");

        assertThat(order.getCost(), is(equalTo(100)));
    }
}