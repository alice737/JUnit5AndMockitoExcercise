package pl.exercise.tests.account;

public class Account {
    private boolean isActive;
    private Address defaultDeliveryAddress;
    private User user;

    Account() {
        this.isActive = false;
    }

    void activate() {
        this.isActive = true;
    }

    public Address getDefaultDeliveryAddress() {
        return defaultDeliveryAddress;
    }

    public void setDefaultDeliveryAddress(Address defaultDeliveryAddress) {
        this.defaultDeliveryAddress = defaultDeliveryAddress;
        if (defaultDeliveryAddress != null) {
            activate();
        }
    }

    public boolean isActive() {
        return isActive;
    }
}
