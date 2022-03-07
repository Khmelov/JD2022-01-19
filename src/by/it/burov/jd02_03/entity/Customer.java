package by.it.burov.jd02_03.entity;

public class Customer {
    private final String name;
    private ShoppingCart shoppingCart;

    private boolean waiting;

    public Customer(int number) {
        name = "Customer " + number;
    }

    public String getName(){
        return name;
    }

    public boolean isWaiting() {
        return waiting;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    public Object getMonitor(){
        return this;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart() {
        this.shoppingCart = new ShoppingCart();
    }

    @Override
    public String toString() {
        return name;
    }


}
