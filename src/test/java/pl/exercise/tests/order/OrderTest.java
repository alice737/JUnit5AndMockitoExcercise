package pl.exercise.tests.order;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

class OrderTest {
    private Order order;

    @BeforeEach
    void initialOrder() {
        order = new Order();
    }

    @AfterEach
    void cleanUp() {
        order.cancel();

    }

    @Test
    void orderMealListIsNull() {
        assertThat(order.getMealList(), empty());
        assertThat(order.getMealList().size(), equalTo(0));
        assertThat(order.getMealList(), hasSize(0));
        assertThat(order.getMealList(), emptyCollectionOf(Meal.class));
    }

    @Test
    void addingMealsToOrderShouldIncreaseSize() {
        Meal meal1 = new Meal(11, "Soup");
        Meal meal2 = new Meal(11, "dessert");
        order.addMealToOrder(meal1);
        order.addMealToOrder(meal2);
        assertThat(order.getMealList().size(), not(equalTo(0)));
        assertThat(order.getMealList(), containsInAnyOrder(meal1, meal2));



    }
    @Test
    void removeFromOrderDecreseSize(){

        Meal meal1 = new Meal(11, "Soup");
        order.addMealToOrder(meal1);
        order.removeMealFromOrder(meal1);
        assertThat(order.getMealList(), hasSize(0));
    }

}