package pl.exercise.tests.card;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import pl.exercise.tests.order.Meal;
import pl.exercise.tests.order.Order;

import java.time.Duration;
import java.util.List;


public class CardTest {
    @Test
    void simiulateLargeOrders() {
        //given
        Card card = new Card();
        //when

        //then
        assertTimeout(Duration.ofMillis(10), card::simiulateLargeOrder);

    }

    @Test
    void cardShouldNotBeEmptyAfterAddOrderToCard() {
        //given
        Card card = new Card();
        Order order = new Order();
        //when
        card.addOrder(order);
        //then
        MatcherAssert.assertThat(card.getOrderList(), Matchers.allOf(
                Matchers.notNullValue(),
                Matchers.hasSize(1),
                Matchers.is(Matchers.not(Matchers.empty())),
                Matchers.not(Matchers.emptyCollectionOf(Order.class))
        ));

        /*this assertion was successfull if any of assert will be true */

        MatcherAssert.assertThat(card.getOrderList(), Matchers.anyOf(
                Matchers.notNullValue(),
                Matchers.hasSize(0),
                Matchers.is(Matchers.not(Matchers.empty())),
                Matchers.not(Matchers.emptyCollectionOf(Order.class))
        ));
        /* we dont focus about first argument like up */
        assertAll(
                () -> MatcherAssert.assertThat(card.getOrderList(), Matchers.notNullValue()),
                () -> MatcherAssert.assertThat(card.getOrderList(), Matchers.hasSize(1)),
                () -> {
                    List<Meal> mealList = card.getOrderList().get(0).getMealList();
                    MatcherAssert.assertThat(mealList, Matchers.empty());
                }

        );
    }

}
