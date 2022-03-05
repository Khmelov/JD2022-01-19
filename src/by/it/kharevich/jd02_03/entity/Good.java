package by.it.kharevich.jd02_03.entity;

public class Good {

    public final String name;
    public final double price;

    public Good(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Good() {
        this("noName", 0);
    }

    @Override
    public String toString() {
        return "Good {" +
                "name ='" + name + '\'' +
                ", price =" + price +
                '}';
    }
}
