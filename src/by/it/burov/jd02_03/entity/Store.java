package by.it.burov.jd02_03.entity;

import by.it.burov.jd02_03.utils.PriceListRepo;

public class Store {

    public static final int COUNT_THREADS = 5;
    public static final int COUNT_CASHIERS = 2;
    public final String name;
    public final Queue queue;
    private final Manager manager;


    public Store(String name, Queue queue, Manager manager) {
        this.name = name;
        this.queue = queue;
        this.manager = manager;
        PriceListRepo.fillCatalog();
    }

    public Queue getQueue() {
        return queue;
    }

    public Manager getManager() {
        return manager;
    }


}
