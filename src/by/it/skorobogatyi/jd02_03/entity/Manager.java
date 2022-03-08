package by.it.skorobogatyi.jd02_03.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Manager {

    private final int PLAN_COUNT;

    public AtomicInteger getCustomerIn() {
        return customerIn;
    }

    public AtomicInteger getCustomerOut() {
        return customerOut;
    }

    private final AtomicInteger customerIn = new AtomicInteger(0);
    private final AtomicInteger customerOut = new AtomicInteger(0);


    public Manager(int planCount) {
        this.PLAN_COUNT = planCount;
    }

    public void customerIn() {
        customerIn.getAndIncrement();
    }

    public void customerOut() {
        customerOut.getAndIncrement();
    }

    public boolean shopOpened() {
        return customerIn.get() != PLAN_COUNT;
    }

    public boolean shopClosed() {
        return customerOut.get() == PLAN_COUNT;
    }
}
