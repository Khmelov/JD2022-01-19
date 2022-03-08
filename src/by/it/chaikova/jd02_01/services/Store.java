package by.it.chaikova.jd02_01.services;

import by.it.chaikova.jd02_01.entity.Customer;
import by.it.chaikova.jd02_01.excertions.StoreExeption;
import by.it.chaikova.jd02_01.utils.RandomData;
import by.it.chaikova.jd02_01.utils.Sleeper;

import java.util.ArrayList;
import java.util.List;

public class Store extends Thread{
    @Override
    public void run() {
        System.out.println("Store opened");
        int i = 0;
        List<Thread> threads = new ArrayList<>();
        for (int time = 0; time < 120; time++) {
            int count = RandomData.get(2);
            for (int j = 0; j < count; j++) {
            Customer customer = new Customer(++i);
            CustomerWorker customerWorker = new CustomerWorker(this,customer);
            threads.add(customerWorker);
            customerWorker.start();
        }
            Sleeper.sleep(1000);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new StoreExeption(e);
            }
        }
        System.out.println("Store closed");
    }
    }

