package by.it.yushkevich.jd02_02.entity;

import java.util.Objects;

public class Customer {

    private final String name;
    private ShoppingCart shoppingCart;

    private boolean waiting;

    public Customer(int number){
        name = "Customer №"+number;

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


    @Override //alt+insert
    public String toString() {
        return name;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart() {
        this.shoppingCart = new ShoppingCart();
    }
}
