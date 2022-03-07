package by.it.kuzma.jd02_02;

import by.it.kuzma.jd02_02.entity.Manager;
import by.it.kuzma.jd02_02.entity.Queue;
import by.it.kuzma.jd02_02.services.Store;

public class Starter {
    public static void main(String[] args) {
        Manager manager = new Manager(100);
        Queue queue = new Queue();
        Store store = new Store(manager, queue);
        store.start();
    }
}
