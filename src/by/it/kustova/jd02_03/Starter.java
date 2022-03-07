package by.it.kustova.jd02_03;

import by.it.kustova.jd02_03.entity.Manager;
import by.it.kustova.jd02_03.entity.Queue;
import by.it.kustova.jd02_03.entity.Store;
import by.it.kustova.jd02_03.services.StoreWorker;

public class Starter {
    public static void main(String[] args) {
        Manager manager = new Manager(100);
        Queue queue = new Queue();
        Store store = new Store(queue, manager);
        StoreWorker storeWorker = new StoreWorker(store);
        storeWorker.start();
    }
}
