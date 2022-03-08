package by.it.yushkevich.jd02_03.entity;

import by.it.yushkevich.jd02_03.entity.Cashier;
import by.it.yushkevich.jd02_03.entity.Customer;
import by.it.yushkevich.jd02_03.entity.Manager;
import by.it.yushkevich.jd02_03.entity.Queue;
import by.it.yushkevich.jd02_03.exceptions.StoreException;
import by.it.yushkevich.jd02_03.services.CashierWorker;
import by.it.yushkevich.jd02_03.services.CustomerWorker;
import by.it.yushkevich.jd02_03.utils.PriceListRepo;
import by.it.yushkevich.jd02_03.utils.RandomData;
import by.it.yushkevich.jd02_03.utils.Sleeper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Store  {


    public static final int THREADS_COUNT = 5;
    public static final int COUNT_CASHIER = 2;
    private final Queue queue;
    private final Manager manager;


    public Store(Manager manager, Queue queue) {

        this.manager = manager;

        this.queue = queue;

        PriceListRepo.fillingListOfPruducts();
    }

    public Queue getQueue() {
        return queue;
    }

    public Manager getManager() {
        return manager;
    }





}
