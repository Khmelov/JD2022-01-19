package by.it.skorobogatyi.jd02_01.entity;

public class Customer {

    private final String name;
    private ShoppingCart shoppingCart;


    public Customer(int number) {
        this.name = "Customer №" + number;
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
