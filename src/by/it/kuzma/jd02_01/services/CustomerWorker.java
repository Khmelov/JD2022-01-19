package by.it.kuzma.jd02_01.services;

import by.it.kuzma.jd02_01.entity.Customer;
import by.it.kuzma.jd02_01.entity.Good;
import by.it.kuzma.jd02_01.entity.ShoppingCart;
import by.it.kuzma.jd02_01.utils.PriceListRepo;
import by.it.kuzma.jd02_01.utils.RandomData;
import by.it.kuzma.jd02_01.utils.Sleeper;

import java.util.Map;


public class CustomerWorker extends Thread implements CustomerAction, ShoppingCardAction{

    private final Customer customer;
    private final Store store;

    public CustomerWorker(Store store, Customer customer) {
        this.customer = customer;
        this.store = store;
        this.setName("Worker for" + customer.toString() + " ");
    }

    @Override
    public void run() {
        enteredStore();
        takeCart();
        int numberOfGoods = RandomData.get(2, 5);
        for (int i = 0; i < numberOfGoods; i++) {
            Good good = chooseGood();
            putToCart(good);
        }
        goOut();

    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " entered to store");
    }

    @Override
    public void takeCart() {
        Sleeper.sleep(RandomData.get(100, 300));
        System.out.println(customer + " took cart");
    }

    @Override
    public Good chooseGood() {
        System.out.println(customer + " started to choose goods");
        int timeout = RandomData.get(500, 2000);
        Sleeper.sleep(timeout);
        int randomGood = RandomData.get(PriceListRepo.priceList.size() - 1);
        Map.Entry<String, Double> entry = PriceListRepo.priceList.entrySet().stream().toList().get(randomGood);
        Good good = new Good(entry.getKey(), entry.getValue());
        System.out.println(customer + " finished to choose goods");

        return good;
    }

    @Override
    public int putToCart(Good good) {

        Sleeper.sleep(RandomData.get(100, 300));

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.goodsInCart.add(good);
        System.out.println(customer + " put into the cart " + good);

        return shoppingCart.goodsInCart.size();
    }

    @Override
    public void goOut() {
        System.out.println(customer + " go out");
    }
}

