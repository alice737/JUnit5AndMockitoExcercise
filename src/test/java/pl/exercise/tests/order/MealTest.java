package pl.exercise.tests.order;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.ArrayList;

import java.util.Collection;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;

/*hamcrest and assertJ matchers*/
class MealTest {

    @Test
    void shouldreturDiscountedValue() throws IllegalAccessException {
        //given
        Meal meal = new Meal(10);
        //when
        int afterDiscount = meal.getDiscount(6);
        // then
        assertEquals(4, afterDiscount);
        assertThat(afterDiscount).isEqualTo(4);
    }

    @Test
    void referencesToTheSameObjectShouldBeEquals() {
        Meal meal = new Meal(2);
        Meal meal1 = meal;
        assertSame(meal, meal1);
        MatcherAssert.assertThat(meal, sameInstance(meal1));
    }

    @Test
    void referencesToDiffirentObjectShouldBeNotTheSaame() {
        Meal meal = new Meal(2);
        Meal meal1 = new Meal(3);
        assertNotSame(meal, meal1, "Expected ouput is same with actual");
        MatcherAssert.assertThat(meal, not(sameInstance(meal1)));
        assertThat(meal).isNotSameAs(meal1);
    }


    @Test
    void mealPriceAssertIlligalExceptin() {

        final Meal meal = new Meal(30, "Soup");
        assertThrows(IllegalAccessException.class, () -> meal.getDiscount(50));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 9})
    void mealshouldBeLowerThen12(int val) {
        MatcherAssert.assertThat(val, lessThan(20));

    }

    @ParameterizedTest
    @MethodSource("createDishFromArguments")
    void burgerAndPrice(String name, int price) {
        MatcherAssert.assertThat(name, containsString("burger"));
        MatcherAssert.assertThat(price, greaterThanOrEqualTo(10));

    }

    @TestFactory
    Collection<DynamicTest> callcutatePricesMeal() {
        Order order = new Order();
        order.addMealToOrder(new Meal(11, "soup", 2));
        order.addMealToOrder(new Meal(13, "burger", 3));

        Collection<DynamicTest> dynamicTests = new ArrayList<>();

        for(int i = 0; i< order.getMealList().size(); i++) {
            int price = order.getMealList().get(i).getPrice();
            int quantity = order.getMealList().get(i).getQuantity();

            Executable executable = () -> {
                MatcherAssert.assertThat(calculatePrice(price, quantity), Matchers.lessThan(68));
            };
            DynamicTest dynamicTest = DynamicTest.dynamicTest("Test "+i, executable);
            ((ArrayList<DynamicTest>) dynamicTests).add(dynamicTest);
        }
        return dynamicTests;
    }

    private int calculatePrice(int price, int quantity){
        return price * quantity;
    }

    private static Stream<Arguments> createDishFromArguments() {
        return Stream.of(Arguments.of("Hamburger", 11),
                Arguments.of("Cheeseburger", 12));
    }

}