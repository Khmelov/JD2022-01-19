package by.it.skorobogatyi.jd02_01.entity;

import by.it.skorobogatyi.jd02_01.utils.PriceListRepo;
import by.it.skorobogatyi.jd02_01.utils.RandomData;
import by.it.skorobogatyi.jd02_01.utils.StoreNames;

public class Store {

    public final String name;
    private int customersAmount;


    public Store(String name) {
        this.name = name;
    }


    public static Store generateStore() {

        int numberOfStoreNames = StoreNames.values().length;

        int randomStoreNumber = RandomData.getRandomNumberForStoreNames(numberOfStoreNames);

        StoreNames randomStoreValue = StoreNames.values()[randomStoreNumber];

        String storeName = String.valueOf(randomStoreValue);

        Store store = new Store(storeName);
        PriceListRepo.fillPriceList();
        return store;
    }

    public void plusCustomersAmount() {
        customersAmount++;
    }

    public void minusCustomersAmount() {
        customersAmount--;
    }

    public int getCustomersAmount() {
        return customersAmount;
    }
}
