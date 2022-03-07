package by.it.skorobogatyi.jd02_03.utils;

import by.it.skorobogatyi.jd02_03.entity.Customer;
import by.it.skorobogatyi.jd02_03.entity.Good;

import java.math.BigDecimal;
import java.util.ArrayList;

import static by.it.skorobogatyi.jd02_03.utils.ColouredPrinter.blueColourPrint;

public class Printer {

    public static final int COLUMN_WIDTH = 33;

    public static synchronized void print(String string) {
        System.out.println(string);
    }

    public static synchronized BigDecimal printCheck(ArrayList<Good> goodsList, Customer customer) {

        BigDecimal checkForCustomer = BigDecimal.valueOf(0);
        blueColourPrint("_".repeat(COLUMN_WIDTH));
        blueColourPrint("|Goods in cart for " + customer + ":");

        for (Good good : goodsList) {
            String goodName = good.name;
            BigDecimal goodPrice = good.price;
            String goodElement = goodName + " \\ price " + goodPrice;
            blueColourPrint("|" + goodElement);
            checkForCustomer = checkForCustomer.add(goodPrice);
        }

        blueColourPrint("|Check for " + customer + ": " + checkForCustomer);
        blueColourPrint("-".repeat(COLUMN_WIDTH));
        return checkForCustomer;
    }
}
