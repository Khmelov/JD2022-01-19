package by.it.yushkevich.jd02_01.entity;

public class Customer {

    private final String name;

    public Customer(int number){
        name = "Customer №"+number;

    }

    @Override //alt+insert
    public String toString() {
        return name;
    }
}
