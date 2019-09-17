package pl.exercise.tests.order;

import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public class OrderBackupTest {
    private static OrderBackup orderBackup;

    @BeforeAll
    static void setUp() throws FileNotFoundException {
        orderBackup = new OrderBackup();
        orderBackup.createFile();
    }

    @BeforeEach
    void beforeTests() throws IOException {
        orderBackup.getWriter().append("Add order: ");
    }

    @Test
    void backupOrderWithOneMeal() throws IOException {
        //given
        Meal meal = new Meal(12, "Soup");
        Order order = new Order();
        order.addMealToOrder(meal);
        //when
        orderBackup.backupOrder(order);
        //then
        System.out.println(order.toString());

    }

    @AfterEach
    void afterTests() throws IOException {
        orderBackup.getWriter().append("backup order.");
    }

    @AfterAll
    static void end() throws IOException {
        orderBackup.closeWriter();
    }
}
