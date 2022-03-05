package by.it.kharevich.jd02_01.services;

import by.it.kharevich.jd02_01.entity.Customer;
import by.it.kharevich.jd02_01.entity.Good;
import by.it.kharevich.jd02_01.entity.ShoppingCart;
import by.it.kharevich.jd02_01.utils.RandomData;
import by.it.kharevich.jd02_01.utils.Sleeper;

import java.util.Set;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCardAction {

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
        int randomGood = RandomData.get(2,5);
        for (int i = 0; i < randomGood; i++) {
            putToCart(chooseGood());
        }
        goOut();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " entered to store");
    }

    @Override
    public void takeCart() {
        System.out.println(customer + " take cart");
    }

    @Override
    public Good chooseGood() {
        System.out.println(customer + " started to choose goods");
        int timeout = RandomData.get(500, 2000);
        Sleeper.sleep(timeout);
        Set<Good> goods = PriceListRepo.priceList.keySet();
        int randomGood = RandomData.get(0, goods.size() - 1);
        System.out.println(customer + " finished to choose goods");
        return goods.stream().toList().get(randomGood);
    }

    @Override
    public int putToCart(Good good) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.goodsAllInCart.add(good);
        System.out.println(customer + " to put " + good + " in cart");
        return shoppingCart.goodsAllInCart.size();
    }

    @Override
    public void goOut() {
        System.out.println(customer + " go out");
    }

}
