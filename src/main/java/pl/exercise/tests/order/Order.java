package pl.exercise.tests.order;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Meal> mealList = new ArrayList<Meal>();

    public List<Meal> getMealList() {
        return mealList;
    }

    public void addMealToOrder(Meal meal) {
        mealList.add(meal);
    }

    public void removeMealFromOrder(Meal meal) {
        mealList.remove(meal);
    }

    public void cancel() {
        this.mealList.clear();
    }

    public void getSumOfMealPrice(){}

    @Override
    public String toString() {
        return "Order{" +
                "mealList=" + mealList +
                '}';
    }
}

