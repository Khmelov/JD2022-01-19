package by.it.yushkevich.jd02_01.entity;

public class Customer {

    private final String name;
    private ShoppingCart shoppingCart;

    public Customer(int number){
        name = "Customer №"+number;

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
