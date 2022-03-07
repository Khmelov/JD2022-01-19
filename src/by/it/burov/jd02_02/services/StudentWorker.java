package by.it.burov.jd02_02.services;

import by.it.burov.jd02_02.entity.Customer;
import by.it.burov.jd02_02.entity.Good;
import by.it.burov.jd02_02.utils.RandomData;

public class StudentWorker extends CustomerWorker {
    private final Customer customer;

    public StudentWorker(Store store, Customer customer) {
        super(store, customer);
        this.customer = customer;
    }

    @Override
    public void run() {
        enteredStore();
        takeCart();
        int fillTheCart = RandomData.get(2);
        if (fillTheCart > 0) {
            for (int i = 0; i < fillTheCart; i++) {
                Good good = chooseGood();
                putToCart(good);
                System.out.println(customer + " has put to the cart " + good);
            }
        } else {
            System.out.println(customer + " has not enough money today");
        }
        goOut();
    }

    @Override
    public void enteredStore() {
        super.enteredStore();
    }

    @Override
    public void takeCart() {
        super.takeCart();
    }

    @Override
    public Good chooseGood() {
        return super.chooseGood();
    }

    @Override
    public void goOut() {
        super.goOut();
    }

    @Override
    public int putToCart(Good good) {
        return super.putToCart(good);
    }
}
