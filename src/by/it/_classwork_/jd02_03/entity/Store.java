package by.it._classwork_.jd02_03.entity;

public class Store {

    public static final int COUNT_THREADS = 5;
    public final int COUNT_CASHIERS = 2;
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

