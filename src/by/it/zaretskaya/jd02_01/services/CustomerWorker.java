package by.it.zaretskaya.jd02_01.services;

import by.it.zaretskaya.jd02_01.entity.Customer;
import by.it.zaretskaya.jd02_01.entity.Good;
import by.it.zaretskaya.jd02_01.utils.RandomData;
import by.it.zaretskaya.jd02_01.utils.Sleeper;

import java.util.Random;

public class CustomerWorker extends Thread implements CustomerAction {

    private final Customer customer;
    private final Store store;

    public CustomerWorker(Store store,Customer customer) {
        this.customer =  customer;
        this.store = store;
        this.setName("Worker for"+customer.toString()+" ");
    }

    @Override
    public void run() {
        enteredStore();
        Good good = chooseGood();
        System.out.println(customer+" choose "+good);
        goOut();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer+" entered to green");
    }

    @Override
    public Good chooseGood() {
        System.out.println(customer+" started to choose goods");
        int timeout = RandomData.get(500, 2000);
        Sleeper.sleeper(timeout);
        System.out.println(customer+" finished to choose goods");
        return new Good();
    }

    @Override
    public void goOut() {
        System.out.println(customer+" go out to green ");
    }
}
