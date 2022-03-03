package by.it.kharevich.jd02_01.entity;

public class Good{

    public final String name;
    public final double price;

    public Good(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Good() {
        this("noName", 0);
    }

    public double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "Good {" +
                "name ='" + name + '\'' +
                ", price =" + price +
                '}';
    }


}
