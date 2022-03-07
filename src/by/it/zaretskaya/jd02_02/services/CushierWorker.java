package by.it.zaretskaya.jd02_02.services;

import by.it.zaretskaya.jd02_02.entity.Cashier;
import by.it.zaretskaya.jd02_02.entity.Customer;
import by.it.zaretskaya.jd02_02.entity.Manager;
import by.it.zaretskaya.jd02_02.entity.Queue;
import by.it.zaretskaya.jd02_02.utils.RandomData;
import by.it.zaretskaya.jd02_02.utils.Sleeper;

import java.util.Optional;

public class CushierWorker implements Runnable{
    private final Cashier cashier;
    private final Store store;

    public CushierWorker(Cashier cashier, Store store) {
        this.cashier = cashier;
        this.store = store;
    }

    @Override
    public void run() {
        System.out.println( "\t" + cashier+" started");
        Manager manager = store.getManager();
        Queue queue = store.getQueue();
        while(!manager.shopClose()){
            Optional<Customer> optionalCustomer = queue.extract();
            if (optionalCustomer.isPresent()){
                Customer customer = optionalCustomer.get();
                System.out.println("\t"+cashier+" start service "+optionalCustomer);
            int timeout = RandomData.get(2000, 5000);
            Sleeper.sleeper(timeout);
            System.out.println("\t"+cashier+" finished service "+optionalCustomer);
            synchronized (customer.getMonitor()){
                customer.setWaiting(false);
                customer.notify();
            }
        } else {
                Sleeper.sleeper(100);
            }
        }
        System.out.println( "\t" + cashier+" finished");

    }
}
