package by.it.skorobogatyi.jd02_03.services;

import by.it.skorobogatyi.jd02_03.entity.Customer;
import by.it.skorobogatyi.jd02_03.entity.Good;
import by.it.skorobogatyi.jd02_03.entity.ShopQueue;
import by.it.skorobogatyi.jd02_03.entity.Store;
import by.it.skorobogatyi.jd02_03.exceptions.StoreException;
import by.it.skorobogatyi.jd02_03.utils.Printer;
import by.it.skorobogatyi.jd02_03.utils.RandomData;
import by.it.skorobogatyi.jd02_03.utils.Sleeper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class CustomerRunner extends Thread implements CustomerAction, ShoppingCartAction {

    private final Customer customer;
    private final StoreRunner storeRunner;
    private final Store store;
    private final int MAX_CARTS_COUNT = 50;
    protected final Semaphore semaphore = new Semaphore(MAX_CARTS_COUNT);


    public CustomerRunner(Customer customer, StoreRunner storeRunner, Store store) {
        this.customer = customer;
        this.storeRunner = storeRunner;
        this.store = store;
        this.setName("Thread for " + customer);
        store.getManager().customerIn();
    }


    @Override
    public void run() {

        enteredStore();

        takeCart();

        int goodsCounter = RandomData.getRandomNumberOfGoods(this);

        for (int i = 0; i < goodsCounter; i++) {
            Good good = chooseGood();
            putToCart(good);
        }

        if (goodsCounter > 0) {
            goToQueue();
        }

        goOut();
    }

    @Override
    public void enteredStore() {

        Printer.print(customer + " entered the store");
    }

    @Override
    public void takeCart() {
        try {
            semaphore.acquire();
            customer.setShoppingCart();
            Printer.print(customer + " took a cart");
        } catch (InterruptedException e) {
            throw new StoreException(e);
        } finally {
            semaphore.release();
        }
    }

    @Override
    public Good chooseGood() {

        Printer.print(customer + " started to choose something");

        int timeForGoodChoice = RandomData.getRandomTimeForGoodsChoosing(this);
        Sleeper.sleep(timeForGoodChoice);

        int randomGoodNumber = RandomData.getRandomGoodsAmount(store);

        Map.Entry<String, BigDecimal> goodEntry =
                store.getStorage()
                .priceList
                .entrySet()
                .stream()
                .toList()
                .get(randomGoodNumber);

        Good good = new Good(goodEntry.getKey(), goodEntry.getValue());

        double timeForPuttingGoodInCart = RandomData.getRandomTimeForGoodsPacking(this);
        Sleeper.sleep(timeForPuttingGoodInCart);

        return good;
    }

    @Override
    public void goToQueue() {

        Printer.print(customer + " waiting in queue");

        synchronized (customer) {
            ShopQueue shopQueue = store.getQueue();
            shopQueue.add(customer);

            customer.setWaiting(true);

            while (customer.isWaiting()) {
                try {
                    customer.wait();
                } catch (InterruptedException e) {
                    throw new StoreException("ERROR: ", e);
                }
            }
        }

        Printer.print(customer + " left queue");
    }

    @Override
    public int putToCart(Good good) {

        ArrayList<Good> goodList = customer.getShoppingCart().goodList;
        goodList.add(good);
        Printer.print(customer + " choose " + good);
        return goodList.size();
    }

    @Override
    public void goOut() {
        Printer.print(customer + " goes home");
        store.getManager().customerOut();
    }
}

