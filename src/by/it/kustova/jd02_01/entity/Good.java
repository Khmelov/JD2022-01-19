package by.it.kustova.jd02_01.entity;

import java.math.BigDecimal;

public class Good {

    public final String name;
    public final BigDecimal price;

    public Good(String name, BigDecimal price) {
        this.name = "Customer " + name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name +
                ", price=" + price;
    }
}
