package by.it.chaikova.jd02_03.entity;

public class Cashier {

    public final String name;

    @Override
    public String toString() {
        return name;
    }

    public Cashier(int number) {
        name = "Cashier №" + number;
    }
}
