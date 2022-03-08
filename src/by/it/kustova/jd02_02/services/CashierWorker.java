package by.it.kustova.jd02_02.services;

import by.it.kustova.jd02_02.entity.*;
import by.it.kustova.jd02_02.utils.RandomData;
import by.it.kustova.jd02_02.utils.Sleeper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class CashierWorker implements Runnable {
    private final Cashier cashier;
    private final Store store;

    public CashierWorker(Cashier cashier, Store store) {
        this.cashier = cashier;
        this.store = store;
    }

    @Override
    public void run() {
        System.out.println("\t" + cashier + "started");
        Manager manager = store.getManager();
        Queue queue = store.getQueue();
        while (!manager.shopClosed()) {
            Optional<Customer> optionalCustomer = queue.extract();
            if (optionalCustomer.isPresent()) {
                Customer customer = optionalCustomer.get();
                System.out.println("\t" + cashier + "start service" + customer);
                int timeout = RandomData.get(2000, 5000);
                Sleeper.sleep(timeout);
                List<Good> goods = customer.getShoppingCard().goods;
                BigDecimal proceeds = BigDecimal.valueOf(0);
                StringBuilder buy = new StringBuilder();
                buy.append("---Check out---").append("\n");
                buy.append(customer).append('\n');
                for (Good good : goods
                ) {
                    buy.append(good.name).append(" = ").append(good.price).append("$").append("\n");
                    proceeds = proceeds.add(good.price);
                }
                buy.append("Total = ").append(proceeds + " $").append("\n");
                buy.append("Thank you for your purchase").append("\n");
                cashier.setMoney(cashier.getMoney().add(proceeds));
                System.out.println("\t" + cashier + "finished service");
                System.out.println(buy.toString());
                synchronized (customer.getMonitor()) {
                    customer.setWaiting(false);
                    customer.notify();
                }
            } else {
                Sleeper.sleep(100);
            }
        }
        BigDecimal sum = cashier.getMoney();
        System.out.println("\t" + cashier + "finished " + " Checkout revenue: " + sum.toString());
    }
}
