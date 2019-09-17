package pl.exercise.tests.card;

import pl.exercise.tests.order.Meal;
import pl.exercise.tests.order.Order;

import java.util.ArrayList;
import java.util.List;

public class Card {
    private List<Order> orderList= new ArrayList<>();

    public void addOrder(Order order) {
        this.orderList.add(order);
    }

    public void clearOrderList() {
        this.orderList.clear();
    }

    public void simiulateLargeOrder() {
       for(int i = 0; i<1000; i++){
           Meal meal = new Meal(12, "Soup");
           Order order = new Order();
           order.addMealToOrder(meal);
           addOrder(order);
       }
       System.out.println(orderList.size());
       clearOrderList();
    }

    public List<Order> getOrderList() {
        return orderList;
    }
}
