package by.it.kustova.jd02_02.entity;

import java.math.BigDecimal;

public class Cashier {
    public final String name;
    public BigDecimal money = BigDecimal.valueOf(0);

    public Cashier(int number) {
        name = "Cashier № " + number;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return name;
    }
}
