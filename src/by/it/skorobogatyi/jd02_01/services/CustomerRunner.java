package by.it.skorobogatyi.jd02_01.services;

import by.it.skorobogatyi.jd02_01.entity.Customer;
import by.it.skorobogatyi.jd02_01.entity.Good;
import by.it.skorobogatyi.jd02_01.entity.Store;
import by.it.skorobogatyi.jd02_01.utils.PriceListRepo;
import by.it.skorobogatyi.jd02_01.utils.RandomData;
import by.it.skorobogatyi.jd02_01.utils.Sleeper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

public class CustomerRunner extends Thread implements CustomerAction, ShoppingCartAction {

    private final Customer customer;
    private final StoreRunner storeRunner;
    private final Store store;


    public CustomerRunner(Customer customer, StoreRunner storeRunner, Store store) {
        this.customer = customer;
        this.storeRunner = storeRunner;
        this.store = store;
        this.setName("Thread for " + customer);
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

        goOut();
    }

    @Override
    public void enteredStore() {

        store.plusCustomersAmount();
        System.out.println(customer + " entered the store");
    }

    @Override
    public void takeCart() {

        customer.setShoppingCart();
        System.out.println(customer + " took a cart");
    }

    @Override
    public Good chooseGood() {

        System.out.println(customer + " started to choose something");

        int timeForGoodChoice = RandomData.getRandomNumberForGoodsChoosing(this);
        Sleeper.sleep(timeForGoodChoice);

        int randomGoodNumber = RandomData.getRandomGoodNumber();

        Map.Entry<String, BigDecimal> goodEntry =
                PriceListRepo
                .priceList
                .entrySet()
                .stream()
                .toList()
                .get(randomGoodNumber);

        Good good = new Good(goodEntry.getKey(), goodEntry.getValue());

        double timeForPuttingGoodInCart = RandomData.getRandomNumberForGoodsPacking(this);
        Sleeper.sleep(timeForPuttingGoodInCart);

        return good;
    }

    @Override
    public int putToCart(Good good) {

        ArrayList<Good> goodList = customer.getShoppingCart().goodList;
        goodList.add(good);
        System.out.println(customer + " choose " + good);
        return goodList.size();
    }

    @Override
    public void goOut() {
        store.minusCustomersAmount();
        System.out.println(customer + " goes home");
    }
}

