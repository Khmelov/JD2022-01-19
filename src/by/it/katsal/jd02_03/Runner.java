package by.it.katsal.jd02_03;

import by.it.katsal.jd02_03.entity.Manager;
import by.it.katsal.jd02_03.entity.Queue;
import by.it.katsal.jd02_03.entity.Store;
import by.it.katsal.jd02_03.services.StoreWorker;

public class Runner {


    public static void main(String[] args) {
        Manager manager = new Manager(100);
        Queue queue = new Queue();
        Store store = new Store("Evroopt", queue, manager);
        StoreWorker storeWorker = new StoreWorker(store);
        storeWorker.start();
    }
}
