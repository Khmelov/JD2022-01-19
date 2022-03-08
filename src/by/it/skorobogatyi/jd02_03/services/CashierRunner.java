package by.it.skorobogatyi.jd02_03.services;

import by.it.skorobogatyi.jd02_03.entity.Cashier;
import by.it.skorobogatyi.jd02_03.entity.Customer;
import by.it.skorobogatyi.jd02_03.entity.Good;
import by.it.skorobogatyi.jd02_03.entity.Store;
import by.it.skorobogatyi.jd02_03.utils.Printer;
import by.it.skorobogatyi.jd02_03.utils.RandomData;
import by.it.skorobogatyi.jd02_03.utils.Sleeper;

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

        ArrayList<Good> goodListOfCustomer = customer.getShoppingCart().goodList;
        BigDecimal checkForCustomer;
        checkForCustomer = Printer.printCheck(goodListOfCustomer, customer, cashier, store);
        store.setOverallMoneyAmount(store.getOverallMoneyAmount().add(checkForCustomer));

        cashier.setMoney(cashier.getMoney().add(checkForCustomer));

        blueColourPrint(cashier + " finished service " + customer);

        //noinspection SynchronizeOnNonFinalField
        synchronized (customer) {
            customer.setWaiting(false);
            customer.notify();
        }
    }

    private void finishWorkForCashier() {
        BigDecimal money = cashier.getMoney();
        blueColourPrint(cashier + " finished to work, money for work day = " + money.toString());

    }
}
