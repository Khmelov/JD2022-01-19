package by.it.tarend.jd02_03.entity;

import by.it.tarend.jd02_03.utils.PriceListRepo;


public class Store{

    private final Manager manager;
    private final Queue queue;

    public Store(Manager manager, Queue queue) {
        this.manager = manager;
        this.queue = queue;
        PriceListRepo.createPriceList();
    }

    public Queue getQueue() {
        return queue;
    }

    public Manager getManager() {
        return manager;
    }

}

