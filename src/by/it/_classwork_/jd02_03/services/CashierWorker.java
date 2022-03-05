package by.it._classwork_.jd02_03.services;

import by.it._classwork_.jd02_03.entity.*;
import by.it._classwork_.jd02_03.utils.RandomData;
import by.it._classwork_.jd02_03.utils.Sleeper;

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
        System.out.println("\t" + cashier + " started");
        Manager manager = store.getManager();
        Queue queue = store.getQueue();
        while (!manager.shopClosed()) {
            Optional<Customer> optionalCustomer = queue.extract();
            if (optionalCustomer.isPresent()) {
                Customer customer = optionalCustomer.get();
                System.out.println("\t" + cashier + " start service " + customer);
                int timeout = RandomData.get(2000, 5000);
                Sleeper.sleep(timeout);
                System.out.println("\t" + cashier + " finished service " + customer);
                synchronized (customer.getMonitor()) {
                    customer.setWaiting(false);
                    customer.notify();
                }
            } else {
                Sleeper.sleep(100);
            }
        }
        System.out.println("\t" + cashier + " finished");
    }
}
