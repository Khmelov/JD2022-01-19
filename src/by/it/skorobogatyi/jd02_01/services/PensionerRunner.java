package by.it.skorobogatyi.jd02_01.services;

import by.it.skorobogatyi.jd02_01.entity.Customer;
import by.it.skorobogatyi.jd02_01.entity.Store;

public class PensionerRunner extends CustomerRunner{

    private final Customer customer;
    private final StoreRunner storeRunner;
    private final Store store;


    public PensionerRunner(Customer customer, StoreRunner storeRunner, Store store) {
        super(customer, storeRunner, store);
        this.customer = customer;
        this.storeRunner = storeRunner;
        this.store = store;
        this.setName("Thread for" + customer);

    }
}
