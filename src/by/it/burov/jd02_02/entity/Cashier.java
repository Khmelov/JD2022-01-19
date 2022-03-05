package by.it.burov.jd02_02.entity;

import java.math.BigDecimal;

public class Cashier {
    public final String name;
    public  BigDecimal income = BigDecimal.valueOf(0);

    public Cashier(int number) {
        name = "Cashier # " + number;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    @Override
    public String toString() {
        return name;
    }
}
