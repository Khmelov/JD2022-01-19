package by.it.zaretskaya.jd02_03.services;

import by.it.zaretskaya.calculator.exeptions.ApplicationException;
import by.it.zaretskaya.jd02_03.entity.Customer;
import by.it.zaretskaya.jd02_03.entity.Good;
import by.it.zaretskaya.jd02_03.entity.Queue;
import by.it.zaretskaya.jd02_03.entity.Store;
import by.it.zaretskaya.jd02_03.utils.RandomData;
import by.it.zaretskaya.jd02_03.utils.Sleeper;

public class CustomerWorker extends Thread implements CustomerAction {

    private final Customer customer;
    private final Store store;

    public CustomerWorker(Store store, Customer customer) {
        this.customer =  customer;
        this.store = store;
        this.setName("Worker for"+customer.toString()+" ");
        store.getManager().customerIn();
    }

    @Override
    public void run() {
        enteredStore();
        Good good = chooseGood();
        System.out.println(customer+" choose "+good);
        goOut();
        store.getManager().customerOut();
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
    public void goToQueue() {
        System.out.println(customer+" waiting in the Queue");
        synchronized (customer) {
            Queue queue = store.getQueue();
            queue.add(customer);
            customer.setWaiting(true);
            while (customer.isWaiting()){
                try {
                    customer.wait();
                } catch (InterruptedException e) {
                    throw new ApplicationException(e);
                }
        }
        }
        System.out.println(customer+" left the Queue");
    }

    @Override
    public void goOut() {
        System.out.println(customer+" go out to green ");

    }
}
