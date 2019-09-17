package pl.exercise.tests.measures;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.sameInstance;

public class CoordinatesTest {

    @Test
    void positionLess0ShouldThrowException(){
        //given
        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            new Coordinates(0,-1);
        });
    }

    @Test
    void positionMore100ShouldByLessThen100(){
        //given
        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            new Coordinates(0,101);
        });
    }

    @Test
    void copyOfCoordinatesShouldReturnNewObject(){
        //given
        Coordinates coordinates = new Coordinates(20,4);
        //when
        Coordinates copy = Coordinates.copy(coordinates, 0 , 0);
        //then
        assertThat(copy, Matchers.not(sameInstance(coordinates)));
        assertThat(copy, Matchers.equalTo(coordinates));


    }

    @Test
    void copyOfCoordinatesShouldChangeXY(){
        //given
        Coordinates coordinates = new Coordinates(20,4);
        //when
        Coordinates copy = Coordinates.copy(coordinates, 1 , 1);
        //then
        MatcherAssert.assertThat(copy.getX(), equalTo(21));
        MatcherAssert.assertThat(copy.getY(), equalTo(5));
    }

}
