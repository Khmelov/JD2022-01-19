package by.it.skorobogatyi.jd02_02.entity;

import java.math.BigDecimal;

public class Cashier {

private final String name;
private BigDecimal money = BigDecimal.valueOf(0);
public boolean isPaused;


    public Cashier(int number) {
        name = "Cashier № " + number;
    }

    @Override
    public String toString() {
        return name;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}