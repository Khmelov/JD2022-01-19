package by.it.chaikova.jd02_03;

import by.it.chaikova.jd02_03.entity.Manager;
import by.it.chaikova.jd02_03.entity.Queue;
import by.it.chaikova.jd02_03.services.Store;

public class Starter {
    public static void main(String[] args) {
        Manager manager = new Manager(100);
        Queue queue = new Queue();
        Store store = new Store(manager, queue);
        store.start();
    }
}
