package by.it.katsal.jd02_02.entity;

public class Cashier {

    public final String name;


    public Cashier(int number) {
        this.name = "Cashier № " + number;
    }


    @Override
    public String toString() {
        return name;
    }
}

