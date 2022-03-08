package by.it.skorobogatyi.jd02_03;

import by.it.skorobogatyi.jd02_03.entity.Store;
import by.it.skorobogatyi.jd02_03.services.StoreRunner;

public class Starter {


    public static void main(String[] args) {

        StoreRunner storeRunner = new StoreRunner(Store.generateStore(100));
        storeRunner.start();
    }
}
