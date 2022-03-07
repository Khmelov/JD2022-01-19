package by.it.kustova.jd02_03.entity;

import by.it.kustova.jd02_03.utils.PriceListRepo;

public class Store {

    public static final int COUNT_THREADS = 5;
    public static final int COUNT_CASHIER = 2;
    private final Queue queue;
    private final Manager manager;

    public Store(Queue queue, Manager manager) {
        this.queue = queue;
        this.manager = manager;
        PriceListRepo.PriceGoods();
    }

    public Queue getQueue() {
        return queue;
    }

    public Manager getManager() {
        return manager;
    }

}

