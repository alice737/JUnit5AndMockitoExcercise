package pl.exercise.tests.order;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class OrderStatusTest {

    @ParameterizedTest
    @EnumSource(OrderType.class)
    void orderStatusShouldBeLessThen15Characters(OrderType orderType){
        MatcherAssert.assertThat(orderType.toString().length(), Matchers.lessThan(15));

    }
}
