package by.it.burov.jd02_03.entity;

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

    public void customerOut() {
        countCustomerOut.getAndIncrement();
    }

    public boolean storeIsOpened() {
        return countCustomerIn.get() != planCount;
    }

    public boolean storeIsClosed() {
        return countCustomerOut.get() == planCount;
    }
}
