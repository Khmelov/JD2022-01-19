package by.it.kharevich.jd02_03.services;

import by.it.kharevich.jd02_03.entity.Cashier;
import by.it.kharevich.jd02_03.entity.Customer;
import by.it.kharevich.jd02_03.entity.Manager;
import by.it.kharevich.jd02_03.entity.Store;
import by.it.kharevich.jd02_03.exceptions.StoreException;
import by.it.kharevich.jd02_03.utils.Constants;
import by.it.kharevich.jd02_03.utils.RandomData;
import by.it.kharevich.jd02_03.utils.Sleeper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class StoreWorker extends Thread{

    private final Store store;

    public StoreWorker(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        Manager manager = store.getManager();
        System.out.println("Store opened");
        int number = 0;
        ExecutorService fixedThreadPoolCashier = Executors.newFixedThreadPool(Constants.COUNT_THREADS_CASHIER);
        for (int i = 1; i <= Constants.LIMIT_COUNT_THREADS_CASHIER; i++) {
            Cashier cashier = new Cashier(i);
            CashierWorker cashierWorker = new CashierWorker(cashier, store);
            fixedThreadPoolCashier.submit(cashierWorker);
        }
        fixedThreadPoolCashier.shutdown();
        while (manager.shopOpened()) {
            int countCustomer = RandomData.get(2);
            for (int i = 0; i < countCustomer && manager.shopOpened(); i++) {
                Customer customer = new Customer(++number);
                CustomerWorker customerWorker = new CustomerWorker(store, customer);
                customerWorker.start();
            }
            Sleeper.sleep(1000);
        }
        try {
            if (fixedThreadPoolCashier.awaitTermination(1, TimeUnit.DAYS)) {
                System.out.println("Store closed");
            }
        } catch (InterruptedException e) {
            throw new StoreException(e);
        }
    }
}
