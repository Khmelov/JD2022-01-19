package by.it.kuzma.jd02_03.entity;

import by.it.kuzma.jd02_03.exceptions.StoreException;
import by.it.kuzma.jd02_03.services.CashierWorker;
import by.it.kuzma.jd02_03.services.CustomerWorker;
import by.it.kuzma.jd02_03.utils.RandomData;
import by.it.kuzma.jd02_03.utils.Sleeper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Store {

    public static final int COUNT_THREADS = 5;
    public static final int COUNT_CASHIERS = 2;
    private final Manager manager;
    private final Queue queue;

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

}

