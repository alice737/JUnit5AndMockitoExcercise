package pl.exercise.tests.order;

public class Meal {
    private int price;
    private String name;

    public Meal(int price, String name) {
        this.price = price;
        this.name = name;
    }
    public Meal(int price) {
        this.price = price;

    }

    public int getPrice() {
        return price;
    }

    public int getDiscount(int discount) throws IllegalAccessException {
        if(discount>this.price)
            throw new IllegalAccessException("discount cannot be higher then price");
        return this.price - discount;
    }
}
