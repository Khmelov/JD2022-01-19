package by.it.yushkevich.jd02_02.entity;

public class Manager {

    private final int planCount;
    private volatile int countCustomerIn;
    private volatile int countCustomerOut;


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
