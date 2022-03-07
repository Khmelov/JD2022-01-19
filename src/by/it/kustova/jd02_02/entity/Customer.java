package by.it.kustova.jd02_02.entity;

public class Customer {

    private final String name;
    private ShoppingCard shoppingCard;
    private boolean waiting;

    public Customer(int number) {
        name = "Customer №" + number;
    }

    public boolean isWaiting() {
        return waiting;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    public void setCart() {
        this.shoppingCard = new ShoppingCard();
    }

    public ShoppingCard getShoppingCard() {
        return shoppingCard;
    }

    public Object getMonitor() {
        return this;
    }

    @Override
    public String toString() {
        return name;
    }
}
