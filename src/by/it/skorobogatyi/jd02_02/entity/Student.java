package by.it.skorobogatyi.jd02_02.entity;

public class Student extends Customer {

    private final String name;
    private ShoppingCart shoppingCart;


    public Student(int number) {
        super(number);
        this.name = "Student №" + number;
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
