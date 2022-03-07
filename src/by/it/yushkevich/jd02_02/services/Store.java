package by.it.yushkevich.jd02_02.services;

import by.it.yushkevich.jd02_02.entity.Cashier;
import by.it.yushkevich.jd02_02.entity.Customer;
import by.it.yushkevich.jd02_02.entity.Manager;
import by.it.yushkevich.jd02_02.entity.Queue;
import by.it.yushkevich.jd02_02.exceptions.StoreException;
import by.it.yushkevich.jd02_02.utils.PriceListRepo;
import by.it.yushkevich.jd02_02.utils.RandomData;
import by.it.yushkevich.jd02_02.utils.Sleeper;

import java.util.ArrayList;
import java.util.List;

public class Store extends Thread {


    private final Queue queue;
    private final Manager manager;


    public Store(Manager manager, Queue queue) {

        this.manager = manager;

        this.queue = queue;

        PriceListRepo.fillingListOfPruducts();
    }

    public Queue getQueue() {
        return queue;
    }

    public Manager getManager() {
        return manager;
    }

    @Override
    public void run() {

        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            CashierWorker cashierWorker = new CashierWorker(cashier, this);
            Thread thread = new Thread(cashierWorker);
            threads.add(thread);
            thread.start();
        }

        //PriceListRepo.fillingListOfPruducts();
        System.out.println("Store opened");

        int number = 0;

        while (manager.shopOpened()) {
            int count = RandomData.get(2);
            for (int i = 0; i < count && manager.shopOpened(); i++) {
                Customer customer = new Customer(++number);

                CustomerWorker customerWorker = new CustomerWorker(this, customer);
                threads.add(customerWorker);
                customerWorker.start();
            }
            Sleeper.sleep(1000);
        }


        for (Thread thread : threads) {
            try {
                thread.join(); //ждем пока закончатся все потоки и потом закрпываем магазин
            } catch (InterruptedException e) {
                throw new StoreException(e);
            }
        }
        System.out.println("Store closed");

    }


}
