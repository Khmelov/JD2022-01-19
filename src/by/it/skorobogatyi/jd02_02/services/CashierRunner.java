package by.it.skorobogatyi.jd02_02.services;

import by.it.skorobogatyi.jd02_02.entity.Cashier;
import by.it.skorobogatyi.jd02_02.entity.Customer;
import by.it.skorobogatyi.jd02_02.entity.Good;
import by.it.skorobogatyi.jd02_02.entity.Store;
import by.it.skorobogatyi.jd02_02.utils.RandomData;
import by.it.skorobogatyi.jd02_02.utils.Sleeper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

import static by.it.skorobogatyi.jd02_02.utils.ColouredPrinter.blueColourPrint;

public class CashierRunner implements Runnable {

    private final Cashier cashier;
    private final Store store;
    private Customer customer;

    public CashierRunner(Cashier cashier, Store store) {
        this.cashier = cashier;
        this.store = store;

    }

    @Override
    public void run() {


        while (!store.getManager().shopClosed()) {


            Optional<Customer> optionalCustomer = store.getQueue().extract();
            if (optionalCustomer.isPresent()) {

                if (cashier.isPaused) {
                    blueColourPrint(cashier + " started to work");
                    cashier.isPaused = false;
                }
                customer = optionalCustomer.get();
                serviceCustomer();

            } else {

                if (!cashier.isPaused) {
                    blueColourPrint(cashier + " paused his work");
                    cashier.isPaused = true;

                } else {
                    Sleeper.sleep(10);
                }
                Sleeper.sleep(10);
            }
        }

        finishWorkForCashier();
    }

    private void serviceCustomer() {

        blueColourPrint(cashier + " started service " + customer);
        int timeForCashier = RandomData.getRandomNumber(2000, 5000);
        Sleeper.sleep(timeForCashier);

        BigDecimal checkForCustomer = BigDecimal.valueOf(0);
        ArrayList<Good> goodListOfCustomer = customer.getShoppingCart().goodList;
        StringBuilder goodsForPrint = new StringBuilder();

        checkForCustomer = countAndPrintCheckForCustomer(goodsForPrint, checkForCustomer, goodListOfCustomer);

        cashier.setMoney(cashier.getMoney().add(checkForCustomer));

        blueColourPrint(cashier + " finished service " + customer);

        synchronized (customer) {
            customer.setWaiting(false);
            customer.notify();
        }
    }

    private BigDecimal countAndPrintCheckForCustomer(StringBuilder goodsForPrint, BigDecimal checkForCustomer, ArrayList<Good> goodListOfCustomer) {

        goodsForPrint.append("_".repeat(50)).append("\n");
        goodsForPrint.append("| Goods in cart for ").append(customer).append(":\n");

        for (Good good : goodListOfCustomer) {
            String goodName = good.name;
            BigDecimal goodPrice = good.price;
            String goodElement = goodName + " for price " + goodPrice + "\n";
            goodsForPrint.append("| ").append(goodElement);
            checkForCustomer = checkForCustomer.add(goodPrice);
        }

        goodsForPrint.append("| Check for ").append(customer).append(": ").append(checkForCustomer).append("\n");
        goodsForPrint.append("-".repeat(50)).append("\n");
        blueColourPrint(String.valueOf(goodsForPrint));

        return checkForCustomer;
    }

    private void finishWorkForCashier() {
        BigDecimal money = cashier.getMoney();
        blueColourPrint(cashier + " finished to work, money for work day = " + money.toString());

    }
}
