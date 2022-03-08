package by.it.yushkevich.jd02_03.entity;

public class Cashier {

    public final String name;

    public Cashier(int number) {
        name = "Кассир № " + number;

    }

    @Override
    public String toString() {
        return name;
    }
}
