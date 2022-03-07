package by.it.yushkevich.jd02_02.services;

import by.it.yushkevich.jd02_02.entity.Customer;
import by.it.yushkevich.jd02_02.entity.Good;
import by.it.yushkevich.jd02_02.utils.PriceListRepo;
import by.it.yushkevich.jd02_02.utils.RandomData;
import by.it.yushkevich.jd02_02.utils.Sleeper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCardAction {

    private final Customer customer;
    private final Store store;

    public CustomerWorker(Store store, Customer customer) {

        this.customer = customer;
        this.store = store;

        this.setName("Worker for " + customer.toString() + " "); //т.к. это поток то можем вот так поставить имя

    }


    @Override
    public void run() {
        enteredStore();
        takeCart();
        int randomAmountOfGoods = RandomData.get(2, 5);
        for (int i = 0; i < randomAmountOfGoods; i++) {
            Good good = chooseGood();
            putToCart(good);
            System.out.println(customer + " положил в корзину товар № " + i + "а именно " + good);

        }

        goOut();

    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " зашел в магазин");
    }

    @Override
    public Good chooseGood() {

        System.out.println(customer + " начал выбирать товар");
        int timeOut = RandomData.get(500, 2000);
        Sleeper.sleep(timeOut);
        int randomGood = RandomData.get(PriceListRepo.listOfProducts.size() - 1);

        Map.Entry<String, BigDecimal> stringDoubleEntry = PriceListRepo.listOfProducts.entrySet()
                .stream().toList().get(randomGood);
        Good good = new Good(stringDoubleEntry.getKey(), stringDoubleEntry.getValue());
        System.out.println(customer + " закончил выбирать товары");
        Sleeper.sleep(RandomData.get(100, 300));
        return good;
    }

    @Override
    public void goOut() {
        System.out.println(customer + " вышел из магазина");
    }

    @Override
    public void takeCart() {
        customer.setShoppingCart();
        System.out.println(customer + " взял корзину");
    }

    @Override
    public int putToCart(Good good) {

        List<Good> goods = customer.getShoppingCart().listOfGoods;
        goods.add(good);
        //System.out.println(customer + " положил " + good + " в корзину");

        return goods.size();
    }

}
