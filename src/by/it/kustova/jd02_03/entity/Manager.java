package by.it.kustova.jd02_03.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Manager {

    private final int planCount;
    private final AtomicInteger countCustomerIn = new AtomicInteger(0);
    private final AtomicInteger countCustomerOut = new AtomicInteger(0);

    public Manager(int planCount) {
        this.planCount = planCount;
    }

    public void customerIn() {
        countCustomerIn.getAndIncrement();
    }

    public void customerGoOut() {
        countCustomerOut.getAndIncrement();
    }

    public boolean shopOpened() {
        return countCustomerIn.get() != planCount;
    }

    public boolean shopClosed() {
        return countCustomerOut.get() == planCount;
    }
}
