package by.it.zaretskaya.jd02_03.entity;

public class Cashier {
    public final String name;

    public Cashier(int number){
        name="Cashier № " +number;
    }

    @Override
    public String toString() {
        return name;
    }
}
