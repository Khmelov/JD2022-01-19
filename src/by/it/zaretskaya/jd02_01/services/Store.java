package by.it.zaretskaya.jd02_01.services;

import by.it.zaretskaya.jd02_01.entity.Customer;
import by.it.zaretskaya.jd02_01.exeptions.StoreException;
import by.it.zaretskaya.jd02_01.utils.RandomData;
import by.it.zaretskaya.jd02_01.utils.Sleeper;


import java.util.ArrayList;
import java.util.List;


public class Store extends Thread{
    @Override
    public void run() {
        System.out.println("green opened");
        int number=0;
        List<Thread> threads=new ArrayList<>();
        for (int second = 0; second < 120; second++) {
            int count = RandomData.get(2);
            for (int i = 0; i < count; i++) {
                Customer customer = new Customer(number);
                CustomerWorker customerWorker = new CustomerWorker(this, customer);
                threads.add(customerWorker);
                customerWorker.start();

            }
            Sleeper.sleeper(1000);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new StoreException(e);
            }
        }
        System.out.println("green closed");



    }
}
