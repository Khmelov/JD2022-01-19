package by.it.burov.jd02_02.services;

import by.it.burov.jd02_02.entity.Customer;
import by.it.burov.jd02_02.entity.Good;
import by.it.burov.jd02_02.entity.Queue;
import by.it.burov.jd02_02.exceptions.StoreException;
import by.it.burov.jd02_02.utils.PriceListRepo;
import by.it.burov.jd02_02.utils.RandomData;
import by.it.burov.jd02_02.utils.Sleeper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class CustomerWorker extends Thread implements CustomerAction,ShoppingCardAction{

    private final Customer customer;
    private final Store store;

    public CustomerWorker(Store store, Customer customer) {
        this.customer = customer;
        this.store = store;
        this.setName("Worker for" + customer.toString() + " ");
        store.getManager().customerIn();
    }

    @Override
    public void run() {
        enteredStore();
        takeCart();
        int fillTheCart = RandomData.get(2,5);
        for (int i = 0; i < fillTheCart; i++) {
            Good good = chooseGood();
            putToCart(good);
            System.out.println(customer + " has put to the cart " + good);
        }
        goToQueue();
        goOut();
        store.getManager().customerOut();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " entered to " + store.name);
    }

    @Override
    public void takeCart() {
        customer.setShoppingCart();
        System.out.println(customer + " has taken the cart");

    }

    @Override
    public Good chooseGood() {
        System.out.println(customer + " started to choose goods");
        int timeout = RandomData.get(500,2000);
        Sleeper.sleep(timeout);
        int randomGood = RandomData.get(PriceListRepo.catalog.size()-1);
        Map.Entry<String, BigDecimal> entry = PriceListRepo.catalog.entrySet().stream().toList().get(randomGood);
        Good good = new Good(entry.getKey(), entry.getValue());
        System.out.println(customer + " has chosen the good");
        Sleeper.sleep(RandomData.get(100,300));
        return good;
    }

    @Override
    public int putToCart(Good good) {
        List<Good> goods = customer.getShoppingCart().goodsInCart;
        goods.add(good);
        return goods.size();
    }

    @Override
    public void goToQueue() {
        System.out.println(customer + " waiting in Queue ");
        synchronized (customer) {
            Queue storeQueue = store.getQueue();
            storeQueue.add(customer);
            customer.setWaiting(true);
            while (customer.isWaiting()) {
                try {
                    customer.wait();
                } catch (InterruptedException e) {
                    throw new StoreException(e);
                }
            }
        }
        System.out.println(customer + " left Queue ");


    }

    @Override
    public void goOut() {
        System.out.println(customer + " goes out");

    }
}
