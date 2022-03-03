package by.it.skorobogatyi.jd02_02.services;

import by.it.skorobogatyi.jd02_02.entity.Manager;
import by.it.skorobogatyi.jd02_02.entity.Store;
import by.it.skorobogatyi.jd02_02.utils.Sleeper;

import java.util.List;

public class ManagerRunner extends Thread {

    private final Store store;
    private final List<Thread> threads;
    private final StoreRunner storeRunner;


    public ManagerRunner(Store store, List<Thread> threads, StoreRunner storeRunner) {
        this.store = store;
        this.threads = threads;
        this.storeRunner = storeRunner;
    }

    @Override
    public void run() {

        threads.add(this);
        Manager manager = store.getManager();

        int cashierNumber = 0;
        while (! manager.shopClosed()) {

            int iterationsNUmber = 0;

            int queueSize = store.getQueue().size();
            int numberOfCashiers = storeRunner.getNumberOfCashiers();

            if (queueSize > 20) {

                for (int i = 0; i < 5 - numberOfCashiers; i++) {
                    storeRunner.getAndRunNewCashier(++cashierNumber, threads);
                    Sleeper.sleep(100);
                    iterationsNUmber++;
                }
                storeRunner.setNumberOfCashiers(numberOfCashiers + iterationsNUmber);

            } else if (queueSize > 15) {
                for (int i = 0; i < 4 - numberOfCashiers; i++) {
                    storeRunner.getAndRunNewCashier(++cashierNumber, threads);
                    Sleeper.sleep(100);
                    iterationsNUmber++;
                }
                storeRunner.setNumberOfCashiers(numberOfCashiers + iterationsNUmber);

            } else if (queueSize > 10) {
                for (int i = 0; i < 3 - numberOfCashiers; i++) {
                    storeRunner.getAndRunNewCashier(++cashierNumber, threads);
                    Sleeper.sleep(100);
                    iterationsNUmber++;
                }
                storeRunner.setNumberOfCashiers(numberOfCashiers + iterationsNUmber);

            } else if (queueSize > 5) {
                for (int i = 0; i < 2 - numberOfCashiers; i++) {
                    storeRunner.getAndRunNewCashier(++cashierNumber, threads);
                    Sleeper.sleep(100);
                    iterationsNUmber++;
                }
                storeRunner.setNumberOfCashiers(numberOfCashiers + iterationsNUmber);

            } else if (queueSize != 0) {
                for (int i = 0; i < 1 - numberOfCashiers; i++) {
                    storeRunner.getAndRunNewCashier(++cashierNumber, threads);
                    Sleeper.sleep(100);
                    iterationsNUmber++;
                }
                storeRunner.setNumberOfCashiers(numberOfCashiers + iterationsNUmber);

            } else {
                Sleeper.sleep(100);
            }
        }
    }
}

