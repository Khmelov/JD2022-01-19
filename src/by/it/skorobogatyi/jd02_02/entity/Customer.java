package by.it.skorobogatyi.jd02_02.entity;

public class Customer {

    private final String name;
    private ShoppingCart shoppingCart;
    private boolean waiting;


    public Customer(int number) {
        this.name = "Customer №" + number;
    }


    public boolean isWaiting() {
        return waiting;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
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
