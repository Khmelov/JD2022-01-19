package by.it.kustova.jd02_03.services;

import by.it._classwork_.calculator.exceptions.ApplacitionException;
import by.it.kustova.jd02_03.entity.Cashier;
import by.it.kustova.jd02_03.entity.Customer;
import by.it.kustova.jd02_03.entity.Manager;
import by.it.kustova.jd02_03.entity.Store;
import by.it.kustova.jd02_03.utils.RandomData;
import by.it.kustova.jd02_03.utils.Sleeper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class StoreWorker extends Thread {
    private final Store store;

    public StoreWorker(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        Manager manager = store.getManager();
        Semaphore semaphore = new Semaphore(1);
        System.out.println("Store opened");
        int number = 0;
        ExecutorService cashierThreadPool = Executors.newFixedThreadPool(Store.COUNT_THREADS);
        for (int i = 1; i <= Store.COUNT_CASHIER; i++) {
            Cashier cashier = new Cashier(i);
            CashierWorker cashierWorker = new CashierWorker(cashier, store);
            cashierThreadPool.submit(cashierWorker);
        }
        cashierThreadPool.shutdown();

        while (manager.shopOpened()) {
            int count = RandomData.get(2);

            for (int i = 0; i < count && manager.shopOpened(); i++) {
                Customer customer = new Customer(++number);
                CustomerWorker customerWorker = new CustomerWorker(customer, store,semaphore);
                customerWorker.start();
            }
            Sleeper.sleep(1000);
        }
        try {
            if (cashierThreadPool.awaitTermination(1, TimeUnit.DAYS)) {
                System.out.println("Store closed");
            }
        } catch (InterruptedException e) {
            throw new ApplacitionException(e);
        }

    }
}
