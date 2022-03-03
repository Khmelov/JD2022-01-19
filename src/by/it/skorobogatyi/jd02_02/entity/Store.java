package by.it.skorobogatyi.jd02_02.entity;

import by.it.skorobogatyi.jd02_02.utils.RandomData;
import by.it.skorobogatyi.jd02_02.utils.StoreNames;

public class Store {

    public final String name;
    private final ShopQueue shopQueue;
    private final Manager manager;
    private final GoodsAndPricesStorage storage;


    public Store(String name, ShopQueue shopQueue, Manager manager) {
        this.name = name;
        this.shopQueue = shopQueue;
        this.manager = manager;
        this.storage = new GoodsAndPricesStorage();
    }


    public Manager getManager() {
        return manager;
    }

    public ShopQueue getQueue() {
        return shopQueue;
    }

    public static Store generateStore(int planCount) {

        int numberOfStoreNames = StoreNames.values().length;

        int randomStoreNumber = RandomData.getRandomStoreNameIndex(numberOfStoreNames);

        StoreNames randomStoreValue = StoreNames.values()[randomStoreNumber];

        String storeName = String.valueOf(randomStoreValue);

        ShopQueue queue = new ShopQueue();
        Manager manager = new Manager(planCount);

        return new Store(storeName, queue, manager);
    }

    public GoodsAndPricesStorage getStorage() {
        return storage;
    }
}
