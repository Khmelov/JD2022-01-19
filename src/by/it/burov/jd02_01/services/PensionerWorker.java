package by.it.burov.jd02_01.services;

import by.it.burov.jd02_01.entity.Customer;
import by.it.burov.jd02_01.entity.Good;
import by.it.burov.jd02_01.utils.PriceListRepo;
import by.it.burov.jd02_01.utils.RandomData;
import by.it.burov.jd02_01.utils.Sleeper;

import java.math.BigDecimal;
import java.util.Map;

public class PensionerWorker extends CustomerWorker {
    private final Customer customer;

    public PensionerWorker(Store store, Customer customer) {
        super(store, customer);
        this.customer = customer;
    }


    @Override
    public void run() {
        super.run();
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
        System.out.println(customer + " started to choose goods");
        double timeout = (RandomData.get(500, 2000) * 1.5);
        Sleeper.sleep(timeout);
        int randomGood = RandomData.get(PriceListRepo.catalog.size() - 1);
        Map.Entry<String, BigDecimal> entry = PriceListRepo.catalog.entrySet().stream().toList().get(randomGood);
        Good good = new Good(entry.getKey(), entry.getValue());
        System.out.println(customer + " has chosen the good");
        Sleeper.sleep(RandomData.get(100, 300) * 1.5);
        return good;
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
