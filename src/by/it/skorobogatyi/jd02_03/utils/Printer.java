package by.it.skorobogatyi.jd02_03.utils;

import by.it.skorobogatyi.jd02_03.entity.Cashier;
import by.it.skorobogatyi.jd02_03.entity.Customer;
import by.it.skorobogatyi.jd02_03.entity.Good;
import by.it.skorobogatyi.jd02_03.entity.Store;

import java.math.BigDecimal;
import java.util.ArrayList;

import static by.it.skorobogatyi.jd02_03.utils.ColouredPrinter.blueColourPrint;

public class Printer {

    public static final int COLUMN_WIDTH = 33;

    public static synchronized void print(String string) {
        System.out.println(string);
    }

    public static synchronized BigDecimal printCheck(ArrayList<Good> goodsList,
                                                     Customer customer,
                                                     Cashier cashier,
                                                     Store store) {

        int repeatsNumber = COLUMN_WIDTH * (cashier.cashierNumber - 1);
        BigDecimal checkForCustomer = BigDecimal.valueOf(0);
        blueColourPrint("_".repeat(COLUMN_WIDTH * 7));
        blueColourPrint(" ".repeat(repeatsNumber)
                + "|Goods in cart for "
                + customer + ":"
                + " ".repeat(COLUMN_WIDTH * (5 - cashier.cashierNumber))
                + "|   Current queue size: " + store.getQueue().size()
                + "|   Overall money amount for store: " + store.getOverallMoneyAmount());

        for (Good good : goodsList) {
            String goodName = good.name;
            BigDecimal goodPrice = good.price;
            String goodElement = goodName + " \\ price " + goodPrice;
            blueColourPrint(" ".repeat(repeatsNumber) + "|" + goodElement);
            checkForCustomer = checkForCustomer.add(goodPrice);
        }

        blueColourPrint(" ".repeat(repeatsNumber) + "|Check for " + customer + ": " + checkForCustomer);
        blueColourPrint("_".repeat(COLUMN_WIDTH * 7));

        return checkForCustomer;
    }
}
