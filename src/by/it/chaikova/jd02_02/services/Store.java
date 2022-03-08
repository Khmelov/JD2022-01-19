package by.it.chaikova.jd02_02.services;

import by.it.chaikova.jd02_02.entity.Cashier;
import by.it.chaikova.jd02_02.entity.Customer;
import by.it.chaikova.jd02_02.entity.Manager;
import by.it.chaikova.jd02_02.entity.Queue;
import by.it.chaikova.jd02_02.excertions.StoreExeption;
import by.it.chaikova.jd02_02.utils.RandomData;
import by.it.chaikova.jd02_02.utils.Sleeper;

import java.util.ArrayList;
import java.util.List;

public class Store extends Thread {

    public Queue getQueue() {
        return queue;
    }

    private final Manager manager;
    private final Queue queue;


    public Store(Manager manager, Queue queue) {
        this.manager = manager;
        this.queue = queue;
    }

    public Manager getManager() {
        return manager;
    }

    @Override
    public void run() {
        System.out.println("Store opened");
        int i = 0;
        List<Thread> threads = new ArrayList<>();


        for (int j = 1; j <= 2; j++) {
            Cashier cashier = new Cashier(j);
            CashierWorker cashierWorker = new CashierWorker(cashier, this);
            Thread thread = new Thread(cashierWorker);
            threads.add(thread);
            thread.start();
        }


        while (manager.shopOpened()) {
            int count = RandomData.get(2);
            for (int j = 0; j < count && manager.shopOpened(); j++) {
                Customer customer = new Customer(++i);
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
                throw new StoreExeption(e);
            }
        }
        System.out.println("Store closed");
    }
}

