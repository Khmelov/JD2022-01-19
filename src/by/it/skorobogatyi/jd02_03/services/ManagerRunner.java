package by.it.skorobogatyi.jd02_03.services;

import by.it.skorobogatyi.jd02_03.entity.Cashier;
import by.it.skorobogatyi.jd02_03.entity.Manager;
import by.it.skorobogatyi.jd02_03.entity.Store;
import by.it.skorobogatyi.jd02_03.utils.Constants;
import by.it.skorobogatyi.jd02_03.utils.Sleeper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ManagerRunner extends Thread {

    private final Store store;
    private final StoreRunner storeRunner;


    public ManagerRunner(Store store, StoreRunner storeRunner) {
        this.store = store;
        this.storeRunner = storeRunner;
    }

    @Override
    public void run() {

        Manager manager = store.getManager();

        ExecutorService cashiersThreadPool = Executors.newFixedThreadPool(Constants.OVERALL_THREADS_COUNT);

        int cashierIndexNumber = 1;

        while (!manager.shopClosed()) {

            int iterationsNumber = 0;

            int queueSize = store.getQueue().size();
            int numberOfCashiers = storeRunner.getNumberOfCashiers();
            int var = (int) Math.ceil(queueSize / 5.);

            for (int i = 0; i < var - numberOfCashiers; i++) {
                CashierRunner cashierRunner = new CashierRunner(new Cashier(cashierIndexNumber), store);
                cashiersThreadPool.submit(cashierRunner);
                Sleeper.sleep(100);
                iterationsNumber++;
            }

            storeRunner.setNumberOfCashiers(numberOfCashiers + iterationsNumber);
        }

        cashiersThreadPool.shutdown();
    }
}

