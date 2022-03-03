package by.it.burov.jd02_01;

import by.it.burov.jd02_01.services.Store;

public class Runner {
    public static void main(String[] args) {
        Store store = new Store("Evroopt");
        store.start();
    }
}
