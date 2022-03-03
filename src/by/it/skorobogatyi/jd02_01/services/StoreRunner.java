package by.it.skorobogatyi.jd02_01.services;

import by.it.skorobogatyi.jd02_01.entity.Pensioner;
import by.it.skorobogatyi.jd02_01.entity.Store;
import by.it.skorobogatyi.jd02_01.entity.Student;
import by.it.skorobogatyi.jd02_01.exceptions.StoreException;
import by.it.skorobogatyi.jd02_01.utils.RandomData;
import by.it.skorobogatyi.jd02_01.utils.Sleeper;

import java.util.ArrayList;
import java.util.List;

public class StoreRunner extends Thread {

    public static final String YELLOW_COLOUR_OUTPUT = "\u001B[33m";
    public static final String END_OF_COLOUR_FORMATTING = "\u001B[0m";
    public final Store store;

    public StoreRunner(Store store) {
        this.store = store;
    }

    @Override
    public void run() {

        System.out.println("Store " + store.name + " opened");

        int customerNumber = 0;

        List<Thread> threads = new ArrayList<>();

        for (int secondOfRun = 0; secondOfRun < 120; secondOfRun++) {
            System.out.println(YELLOW_COLOUR_OUTPUT + "Passed " + secondOfRun +
                    " seconds, number of buyers = " + store.getCustomersAmount() + END_OF_COLOUR_FORMATTING);


            int customersAmount = RandomData.getRandomNumber(10, 15);

            for (int i = 0; i < customersAmount; i++) {

                if (secondOfRun <= 30) {
                    if (store.getCustomersAmount() <= secondOfRun + 10) {
                        generateAndProceedNewCustomerRunner(++customerNumber, threads);

                    }

                } else if (secondOfRun <= 60) {
                    if (store.getCustomersAmount() <= 40 + (30 - secondOfRun)) {
                        generateAndProceedNewCustomerRunner(++customerNumber, threads);
                    }

                } else if (secondOfRun <= 90) {
                    if (store.getCustomersAmount() <= secondOfRun - 60 + 10) {
                        generateAndProceedNewCustomerRunner(++customerNumber, threads);

                    }
                } else {
                    if (store.getCustomersAmount() <= 40 + (30 - secondOfRun + 60)) {
                        generateAndProceedNewCustomerRunner(++customerNumber, threads);

                    }
                }
            }
            Sleeper.sleep(1000);
        }
        System.out.println(YELLOW_COLOUR_OUTPUT + "Shop is closing" + END_OF_COLOUR_FORMATTING);

        joinThreads(threads);

        System.out.println(YELLOW_COLOUR_OUTPUT + "Store " + store.name + " closed" + END_OF_COLOUR_FORMATTING);
    }

    private void joinThreads(List<Thread> threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new StoreException(e);
            }
        }
    }

    private void generateAndProceedNewCustomerRunner(int customerNumber, List<Thread> threads) {
        CustomerRunner customerRunner = generateNewCustomerRunner(customerNumber);
        threads.add(customerRunner);
        customerRunner.start();
    }

    private CustomerRunner generateNewCustomerRunner(int customerNumber) {

        int customerRole = RandomData.getRandomNumber(3); //choosing customer role

        CustomerRunner customerRunner;

        switch (customerRole) {
            case 0 -> customerRunner = new StudentRunner(new Pensioner(customerNumber), this, store);
            case 1, 2 -> customerRunner = new PensionerRunner(new Student(customerNumber), this, store);
            default -> customerRunner = new CustomerRunner(new Student(customerNumber), this, store);
        }
        return customerRunner;
    }
}


