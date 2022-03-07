package by.it.tarend.jd02_03.entity;

public class Good {

    public final String name;
    public final double price;

    public Good(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Good() {
        this("noname", 0);
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " by price = " + price;
    }
}
