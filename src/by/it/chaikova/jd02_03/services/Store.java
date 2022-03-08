package by.it.chaikova.jd02_03.services;

import by.it.chaikova.jd02_03.entity.Cashier;
import by.it.chaikova.jd02_03.entity.Customer;
import by.it.chaikova.jd02_03.entity.Manager;
import by.it.chaikova.jd02_03.entity.Queue;
import by.it.chaikova.jd02_03.excertions.StoreExeption;
import by.it.chaikova.jd02_03.utils.RandomData;
import by.it.chaikova.jd02_03.utils.Sleeper;
import com.sun.source.tree.CompilationUnitTree;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Store extends Thread {

    public static final int COUNT_THREADS = 5;
    public static final int COUNT_CASHIERS = 2;

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

        ExecutorService cashierPool = Executors.newFixedThreadPool(COUNT_THREADS);

        for (int j = 1; j <= COUNT_CASHIERS; j++) {
            Cashier cashier = new Cashier(j);
            CashierWorker cashierWorker = new CashierWorker(cashier, this);
            cashierPool.submit(cashierWorker);
        }
        cashierPool.shutdown();

        while (manager.shopOpened()) {
            int count = RandomData.get(2);
            for (int j = 0; j < count && manager.shopOpened(); j++) {
                Customer customer = new Customer(++i);
                CustomerWorker customerWorker = new CustomerWorker(this, customer);
                customerWorker.start();
            }
            Sleeper.sleep(1000);
        }

while (!cashierPool.isTerminated()) {
    Thread.onSpinWait();
}
    System.out.println("Store closed");
}

}

