package by.it.skorobogatyi.jd02_02.entity;

public class Manager {

    public final int PLAN_COUNT;
    public volatile int customerIn;
    public volatile int customerOut;


    public Manager(int planCount) {
        this.PLAN_COUNT = planCount;
    }

    public synchronized void customerIn() {
        customerIn++;
    }

    public synchronized void customerOut() {
        customerOut++;
    }

    public boolean shopOpened() {
        return customerIn != PLAN_COUNT;
    }

    public boolean shopClosed() {
        return customerOut == PLAN_COUNT;
    }
}
