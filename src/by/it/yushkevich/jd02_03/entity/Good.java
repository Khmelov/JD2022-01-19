package by.it.yushkevich.jd02_03.entity;

import java.math.BigDecimal;

public class Good {

    public final String name;
    //public final double price;
    public final BigDecimal price;

    public Good(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return  name + ", цена=" + price;
    }
}
