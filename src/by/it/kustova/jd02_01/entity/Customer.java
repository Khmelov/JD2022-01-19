package by.it.kustova.jd02_01.entity;

public class Customer {

    private final String name;
    private ShoppingCard shoppingCard;

    public Customer(int number) {
        name = "Customer №" + number;
    }

    public void setCart() {
        this.shoppingCard = new ShoppingCard();
    }

    public ShoppingCard getShoppingCard() {
        return shoppingCard;
    }

    @Override
    public String toString() {
        return name;
    }
}
