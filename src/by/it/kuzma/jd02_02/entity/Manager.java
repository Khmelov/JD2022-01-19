package by.it.kuzma.jd02_02.entity;

public class Manager {

    public final int planCount;
    public volatile int countCustomerIn;
    public volatile int countCustomerOut;

    public Manager(int planCount) {
        this.planCount = planCount;
    }

    public synchronized void customerIn() {
        countCustomerIn++;
    }

    public synchronized void customerGoOut() {
        countCustomerOut++;
    }

    public boolean shopOpened() {
        return countCustomerIn != planCount;
    }

    public boolean shopClosed() {
        return countCustomerOut == planCount;
    }
}
