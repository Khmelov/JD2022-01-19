package by.it.yushkevich.jd02_01.services;

import by.it.yushkevich.jd02_01.entity.Customer;
import by.it.yushkevich.jd02_01.entity.Good;
import by.it.yushkevich.jd02_01.utils.RandomData;
import by.it.yushkevich.jd02_01.utils.Sleeper;

public class CustomerWorker extends Thread implements CustomerAction{

    private final Customer customer;
    private final Store store;

    public CustomerWorker( Store store, Customer customer) {

        this.customer = customer;
        this.store = store;

        this.setName("Worker for "+customer.toString()+" "); //т.к. это поток то можем вот так поставить имя

    }


    @Override
    public void run() {
        enteredStore();
        Good good = chooseGood();
        System.out.println(customer+ " choose "+ good);
        goOut();

    }

    @Override
    public void enteredStore() {
        System.out.println(customer+" зашел в магазин");
    }

    @Override
    public Good chooseGood() {

        System.out.println(customer+" начал выбирать товары");
        int timeOut = RandomData.get(500, 2000);
        Sleeper.sleep(timeOut);
        System.out.println(customer+" закончил выбирать товары");
        return new Good();
    }

    @Override
    public void goOut() {
        System.out.println(customer+" вышел из магазина");
    }
}
