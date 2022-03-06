package by.it.tarend.jd02_03.entity;

public class Customer {

    private final String name;
    private boolean waiting;
    private ShoppingCart shoppingCart;
    public double bill = 0.0;

    public Customer(int number) {
        name = "Customer № " + number;
    }

    public boolean isWaiting() {
        return waiting;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    public Object getMonitor() {
        return  this;
    }

    public void setShoppingCart() {
        this.shoppingCart = new ShoppingCart();
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    @Override
    public String toString() {
        return name;
    }
}
