package pl.exercise.tests.order;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import pl.exercise.tests.order.Meal;
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
        assertNotSame(meal, meal1,  "Expected ouput is same with actual");
        MatcherAssert.assertThat(meal, not(sameInstance(meal1)));
        assertThat(meal).isNotSameAs(meal1);
    }


    @Test
    void mealPriceAssertIlligalExceptin() {

        final Meal meal = new Meal(30, "Soup");
        assertThrows(IllegalAccessException.class, () -> meal.getDiscount(50));
    }

}