package pl.exercise.tests.measures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UnitTest {

    @Test
    void moveShouldReturnException(){
        //given
        Coordinates coordinates = new Coordinates(10, 19);
        //then
        Unit unit = new Unit(coordinates, 19, 200);
        //when
        Assertions.assertThrows(IllegalStateException.class, ()->{
            unit.move(10, 30);
        });
    }


}
