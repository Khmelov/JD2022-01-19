package by.it.burov.jd02_02.entity;

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

    public synchronized void customerOut() {
        countCustomerOut++;
    }

    public boolean storeIsOpened() {
        return countCustomerIn != planCount;
    }

    public boolean storeIsClosed(){
        return countCustomerOut == planCount;
    }
}
