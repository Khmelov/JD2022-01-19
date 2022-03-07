package by.it.tarend.jd02_03.services;

import by.it.tarend.jd02_03.entity.Cashier;
import by.it.tarend.jd02_03.entity.Customer;
import by.it.tarend.jd02_03.entity.Manager;
import by.it.tarend.jd02_03.entity.Store;
import by.it.tarend.jd02_03.exceptions.StoreException;
import by.it.tarend.jd02_03.utils.RandomData;
import by.it.tarend.jd02_03.utils.Sleeper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class StoreWorker extends Thread{

    private final Store store;
    private final Semaphore semaphoreHall = new Semaphore(20);

    public StoreWorker(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        Manager manager = store.getManager();
        System.out.println("Store opened");
        ExecutorService cashierThreadPool = Executors.newFixedThreadPool(5);
        int number = 0;
        for (int i = 1; i <= 2 ; i++) {
            Cashier cashier = new Cashier(i);
            CashierWorker cashierWorker = new CashierWorker(cashier, store);
            cashierThreadPool.submit(cashierWorker);
        }
        cashierThreadPool.shutdown();
        while (manager.shopOpened()) {
            int count = RandomData.get(2);
            for (int i = 0; i < count && manager.shopOpened(); i++) {
                Customer customer = new Customer(++number);
                CustomerWorker customerWorker = new CustomerWorker(store, customer);
                try {
                    semaphoreHall.acquire();
                    customerWorker.start();
                } catch (InterruptedException e) {
                    throw new StoreException(e);
                } finally {
                    semaphoreHall.release();
                }
            }
            Sleeper.sleep(1000);
        }
        try {
            if (cashierThreadPool.awaitTermination(1, TimeUnit.DAYS)) {
                System.out.println("Store closed");
            }
        } catch (InterruptedException e) {
            throw new StoreException(e);
        }

    }
}
