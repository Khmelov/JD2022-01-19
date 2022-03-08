package by.it.burov.jd02_03;

import by.it.burov.jd02_03.entity.Manager;
import by.it.burov.jd02_03.entity.Queue;
import by.it.burov.jd02_03.entity.Store;
import by.it.burov.jd02_03.services.StoreWorker;

public class Runner {

   /* public static void main1(String[] args) {
        for (int i = 0; i < 100; i++) {
            main1(args);
        }
    }*/

    public static void main(String[] args) {
        Manager manager = new Manager(100);
        Queue queue = new Queue();
        Store store = new Store("Evroopt", queue, manager);
        StoreWorker storeWorker = new StoreWorker(store);
        storeWorker.start();
    }
}
