package by.it.burov.jd02_02.services;

import by.it.burov.jd02_02.entity.Cashier;
import by.it.burov.jd02_02.entity.Manager;
import by.it.burov.jd02_02.entity.Queue;
import by.it.burov.jd02_02.utils.PriceListRepo;
import by.it.burov.jd02_02.utils.Sleeper;
import by.it.burov.jd02_02.entity.Customer;
import by.it.burov.jd02_02.exceptions.StoreException;
import by.it.burov.jd02_02.utils.RandomData;

import java.util.ArrayList;
import java.util.List;

public class Store extends Thread {

    public final String name;
    public final Queue queue;
    private final Manager manager;


    public Store(String name, Queue queue, Manager manager) {
        this.name = name;
        this.queue = queue;
        this.manager = manager;
        PriceListRepo.fillCatalog();
    }

    public Queue getQueue() {
        return queue;
    }

    public Manager getManager() {
        return manager;
    }

    @Override
    public void run() {
        System.out.println("Store opened");
        int number = 0;
        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            CashierWorker cashierWorker = new CashierWorker(cashier, this);
            Thread thread = new Thread(cashierWorker);
            threads.add(thread);
            thread.start();
        }
        while (manager.storeIsOpened()) {
            int count = RandomData.get(2);
            for (int i = 0; i < count && manager.storeIsOpened(); i++) {
                Customer customer = new Customer(++number);
                CustomerWorker customerWorker = new CustomerWorker(this, customer);
                threads.add(customerWorker);
                customerWorker.start();
            }
            Sleeper.sleep(1000);
        }


        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new StoreException(e);
            }
        }
        System.out.println("Store closed");
    }
}
