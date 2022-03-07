package by.it.burov.jd02_01.services;

import by.it.burov.jd02_01.entity.Customer;
import by.it.burov.jd02_01.entity.Pensioner;
import by.it.burov.jd02_01.entity.Student;
import by.it.burov.jd02_01.exceptions.StoreException;
import by.it.burov.jd02_01.utils.PriceListRepo;
import by.it.burov.jd02_01.utils.RandomData;
import by.it.burov.jd02_01.utils.Sleeper;

import java.util.ArrayList;
import java.util.List;

public class Store extends Thread {

    public final String name;

    public Store(String name) {
        this.name = name;
        PriceListRepo.fillCatalog();
    }


    @Override
    public void run() {
        System.out.println("Store" + name + "opened");
        int customerNumber = 0;
        List<Thread> threads = new ArrayList<>();
        for (int time = 0; time < 120; time++) {
            int count = RandomData.get(10, 15);
            customerNumber = rushHours(customerNumber, threads, time, count);
            Sleeper.sleep(1000);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new StoreException(e);
            }
        }
        System.out.println("Store " + name + " closed");
    }

    private int rushHours(int customerNumber, List<Thread> threads, int time, int count) {
        for (int i = 0; i < count; i++) {
            if (time <= 30) {
                if (customerNumber <= time + 10) {
                    createCustomer(++customerNumber, threads);
                }
            } else if (time <= 60) {
                if (customerNumber <= 40 + (30 - time)) {
                    createCustomer(++customerNumber, threads);
                }
            } else if (time <= 90) {
                if (customerNumber <= time - 60 + 10) {
                    createCustomer(++customerNumber, threads);
                }
            } else {
                if (customerNumber <= 40 + (30 - time + 60)) {
                    createCustomer(++customerNumber, threads);
                }
            }
        }
        return customerNumber;
    }

    private void createCustomer(int currentQuantityCustomers, List<Thread> threads) {
        CustomerWorker customerWorker = createTypeOfCustomer(currentQuantityCustomers);
        threads.add(customerWorker);
        customerWorker.start();
    }

    private CustomerWorker createTypeOfCustomer(int customerNumber) {
        int choosing = RandomData.get(3);
        CustomerWorker customerWorker;
        if (choosing == 0) {
            customerWorker = new PensionerWorker(this, new Pensioner(customerNumber));
        } else if (choosing == 1 || choosing == 2) {
            customerWorker = new StudentWorker(this, new Student(customerNumber));
        } else {
            customerWorker = new CustomerWorker(this, new Customer(customerNumber));
        }
        return customerWorker;
    }
}
