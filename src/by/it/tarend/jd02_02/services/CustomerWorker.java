package by.it.tarend.jd02_02.services;

import by.it.tarend.jd02_02.entity.Customer;
import by.it.tarend.jd02_02.entity.Good;
import by.it.tarend.jd02_02.entity.Queue;
import by.it.tarend.jd02_02.entity.ShoppingCart;
import by.it.tarend.jd02_02.exceptions.StoreException;
import by.it.tarend.jd02_02.utils.PriceListRepo;
import by.it.tarend.jd02_02.utils.RandomData;
import by.it.tarend.jd02_02.utils.Sleeper;

import java.util.Set;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCardAction{

    private final Customer customer;
    private final Store store;

    public CustomerWorker(Store store, Customer customer) {
        this.customer = customer;
        this.store = store;
        this.setName("Worker name "  + customer.toString() + " ");
        store.getManager().customerIn();
    }

    @Override
    public void run() {

        enteredStore();
        takeCart();
        int randomGoodNumber = RandomData.get(2,5);
        for (int i = 0; i < randomGoodNumber; i++) {
            putToCart(chooseGood());
        }

        goOut();
        store.getManager().customerOut();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " entered to store");

    }

    @Override
    public Good chooseGood() {

        System.out.println(customer + " started to choose goods");
        int timeOut = RandomData.get(500, 2000);
        Sleeper.sleep(timeOut);
        Set<Good> goods = PriceListRepo.priceList.keySet();
        int randomGoodIndex = RandomData.get(0, goods.size() - 1);
        System.out.println(customer + " finished to choose goods");

        return goods.stream().toList().get(randomGoodIndex);
    }

    @Override
    public void goToQueue() {
        System.out.println(customer + " go to Queue");
        synchronized (customer) {
            Queue queue = store.getQueue();
            queue.add(customer);
            customer.setWaiting(true);
            while (customer.isWaiting()){
                try {
                    customer.wait();
                } catch (InterruptedException e) {
                    throw  new StoreException(e);
                }
            }
        }
        System.out.println(customer + " left Queue");
    }

    @Override
    public void takeCart() {
        int timeOut = RandomData.get(100,300);
        Sleeper.sleep(timeOut);
        System.out.println(customer + " took Cart");
    }

    @Override
    public int putToCart(Good good) {
        int timeOut = RandomData.get(100,300);
        Sleeper.sleep(timeOut);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.putGoodIntoCart(good);
        System.out.println(customer + " put " + good + " into cart");

        return shoppingCart.goodsInCart.size();
    }

    @Override
    public void goOut() {

        System.out.println(customer + " go out");
    }
}
