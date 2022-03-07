package by.it.burov.jd02_02.services;

import by.it.burov.jd02_02.entity.Manager;

import java.util.List;

public class ManagerWorker extends Thread {
    private final Manager manager;
    private final Store store;
    private final List<Thread> threads;

    public ManagerWorker(Manager manager, Store store, List<Thread> threads) {
        this.manager = manager;
        this.store = store;
        this.threads = threads;

    }

    @Override
    public void run() {

    }
}
