package by.it.kustova.jd02_01.services;

import by.it.kustova.jd02_01.entity.Customer;
import by.it.kustova.jd02_01.entity.Good;
import by.it.kustova.jd02_01.utils.PriceListRepo;
import by.it.kustova.jd02_01.utils.RandomData;
import by.it.kustova.jd02_01.utils.Sleeper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCardAction {

    private final Customer customer;
    private final Store store;

    public CustomerWorker(Customer customer, Store store) {
        this.customer = customer;
        this.store = store;
        this.setName("Worker for " + customer.toString() + " ");
    }


    @Override
    public void run() {
        enteredStore();

        takeCart();

        int fillCart = RandomData.get(2, 5);

        for (int i = 0; i < fillCart; i++) {
            Good good = chooseGood();
            putToCart(good);
            System.out.println(customer + " put to cart goods № " + i + " " + good);
        }
        goOut();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " entered to store");
    }

    @Override
    public void takeCart() {
        customer.setCart();
        System.out.println(customer + "is taking cart!");
    }

    @Override
    public Good chooseGood() {
        System.out.println(customer + " started to choose goods");
        int timeout = RandomData.get(500, 2000);
        Sleeper.sleep(timeout);
        int randomGoods = RandomData.get(PriceListRepo.priceList.size() - 1);
        Map.Entry<String, BigDecimal> entry = PriceListRepo
                .priceList
                .entrySet()
                .stream()
                .toList()
                .get(randomGoods);
        Good goods = new Good(entry.getKey(), entry.getValue());
        System.out.println(customer + " finished choose goods");
        Sleeper.sleep(RandomData.get(100, 300));
        return goods;
    }

    @Override
    public void goOut() {
        System.out.println(customer + " go out");
    }


    @Override
    public int putToCart(Good good) {
        ArrayList<Good> goodList = (ArrayList<Good>) customer.getShoppingCard().goods;
        goodList.add(good);
        return goodList.size();
    }


}
