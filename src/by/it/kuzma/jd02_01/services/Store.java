package by.it.kuzma.jd02_01.services;

import by.it.kuzma.jd02_01.entity.Customer;
import by.it.kuzma.jd02_01.exception.StoreException;
import by.it.kuzma.jd02_01.utils.PriceListRepo;
import by.it.kuzma.jd02_01.utils.RandomData;
import by.it.kuzma.jd02_01.utils.Sleeper;

import java.util.ArrayList;
import java.util.List;

public class Store extends Thread{

    public Store(){
        PriceListRepo.priceGood();
    }

    @Override
    public void run() {
        System.out.println("Store opened");
        int number = 0;
        List<Thread> threads = new ArrayList<>();
        for (int time = 0; time < 120; time++) {
            int count = RandomData.get(2);
            for (int i = 0; i < count; i++) {

                Customer customer = new Customer(++number);
                CustomerWorker customerWorker = new CustomerWorker(this, customer);
                threads.add(customerWorker);
                customerWorker.start();
            }
            Sleeper.sleep(1000);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new StoreException(e);
            }
        }
        System.out.println("Store closed");
    }
}
