package by.it.kharevich.jd02_02.services;

import by.it.kharevich.jd02_02.entity.Cashier;
import by.it.kharevich.jd02_02.entity.Customer;
import by.it.kharevich.jd02_02.entity.Manager;
import by.it.kharevich.jd02_02.entity.Queue;
import by.it.kharevich.jd02_02.exceptions.StoreException;
import by.it.kharevich.jd02_02.utils.RandomData;
import by.it.kharevich.jd02_02.utils.Sleeper;

import java.util.ArrayList;
import java.util.List;

public class Store extends Thread {


    private final Manager manager;
    private  final Queue queue;

    public Store(Manager manager, Queue queue) {
        this.manager = manager;
        this.queue = queue;
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
        while (manager.shopOpened()) {
            int countCustomer = RandomData.get(2);
            for (int i = 0; i < countCustomer && manager.shopOpened(); i++) {
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
                throw new StoreException();
            }
        }
        System.out.println("Store closed");
    }
}
