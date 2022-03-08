package by.it.chaikova.jd02_03.services;

import by.it.chaikova.jd02_03.entity.Cashier;
import by.it.chaikova.jd02_03.entity.Customer;
import by.it.chaikova.jd02_03.entity.Manager;
import by.it.chaikova.jd02_03.entity.Queue;
import by.it.chaikova.jd02_03.utils.RandomData;
import by.it.chaikova.jd02_03.utils.Sleeper;

import java.util.Optional;

public class CashierWorker implements Runnable{

private  final Cashier cashier;
private final Store store;

    public CashierWorker(Cashier cashier, Store store) {
        this.cashier = cashier;
        this.store = store;
    }


    @Override
    public void run() {
        System.out.println("\t"+cashier+ "started");
        Manager manager = store.getManager();
        Queue queue = store.getQueue();
while (!manager.shopClosed()){
    Optional<Customer> optionalCustomer = queue.extact();
    if (optionalCustomer.isPresent()) {
        Customer customer = optionalCustomer.get();
        System.out.println("\t" + cashier + " start service " + customer);
        int timeOut = RandomData.get(2000, 5000);
        Sleeper.sleep(timeOut);

        System.out.println("\t" + cashier + " finish service " + customer);
        synchronized (customer.getMonitor()){
            customer.setWaiting(false);
            customer.notify();
        }
    } else {
        Sleeper.sleep(100);
    }
}
        System.out.println("\t"+cashier+ "finished");

    }
}
