package by.it.skorobogatyi.jd02_02.services;

import by.it.skorobogatyi.jd02_02.entity.*;
import by.it.skorobogatyi.jd02_02.exceptions.StoreException;
import by.it.skorobogatyi.jd02_02.utils.RandomData;
import by.it.skorobogatyi.jd02_02.utils.Sleeper;

import java.util.ArrayList;
import java.util.List;

import static by.it.skorobogatyi.jd02_02.utils.ColouredPrinter.yellowColourPrint;

public class StoreRunner extends Thread {

    public final Store store;
    private final List<Thread> threads;
    private volatile int numberOfCashiers;

    public StoreRunner(Store store) {
        this.store = store;
        this.threads = new ArrayList<>();
    }

    @Override
    public void run() {

        yellowColourPrint("Store " + store.name + " opened");

        int customerNumber = 0;
        int minuteOfRun = 0;

        Manager managerOfThisStore = store.getManager();
        getAndRunManager(threads, this);

        while (managerOfThisStore.shopOpened()) {

            int secondOfRun = customerNumber;

            if (secondOfRun == 60) {
                secondOfRun = 0;
                minuteOfRun++;
            }

            int numberOfGeneratedCustomers = RandomData.getRandomNumber(100, 1000);
            int currentNumberOfCustomersInStore = managerOfThisStore.customerIn - managerOfThisStore.customerOut;

            for (int i = 0; i < numberOfGeneratedCustomers && managerOfThisStore.shopOpened(); i++) {

                if (conditionCheck(secondOfRun)) {
                    if (currentNumberOfCustomersInStore <= secondOfRun - minuteOfRun * 60 + 10) {
                        generateAndRunNewCustomerRunner(++customerNumber, threads);
                    }

                } else {
                    if (currentNumberOfCustomersInStore <= 40 + (30 - secondOfRun + minuteOfRun * 60)) {
                        generateAndRunNewCustomerRunner(++customerNumber, threads);
                    }
                }

                Sleeper.sleep(1000);
            }

        }

        startToCloseShop(threads);
    }

    private boolean conditionCheck(int secondOfRun) {
        double tempResult = (double) secondOfRun / 60;
        double finalResult = tempResult % 1;
        return finalResult < 0.5;
    }

    private void getAndRunManager(List<Thread> threads, StoreRunner storeRunner) {
        ManagerRunner managerRunner = new ManagerRunner(store, threads, storeRunner);
        this.threads.add(managerRunner);
        managerRunner.start();
    }

    public void getAndRunNewCashier(int number, List<Thread> threads) {
        CashierRunner cashierRunner = new CashierRunner(new Cashier(number), store);
        Thread thread = new Thread(cashierRunner);
        threads.add(thread);
        thread.start();
    }

    private void generateAndRunNewCustomerRunner(int customerNumber, List<Thread> threads) {
        CustomerRunner customerRunner = generateNewCustomerRunner(customerNumber);
        threads.add(customerRunner);
        customerRunner.start();
    }

    private CustomerRunner generateNewCustomerRunner(int customerNumber) {

        int customerRole = RandomData.getRandomNumber(3); //choosing customer role

        CustomerRunner customerRunner;

        switch (customerRole) {
            case 0 -> customerRunner = new PensionerRunner(
                    new Pensioner(customerNumber), this, store);
            case 1, 2 -> customerRunner = new StudentRunner(
                    new Student(customerNumber), this, store);
            default -> customerRunner = new CustomerRunner(
                    new Customer(customerNumber), this, store);
        }
        return customerRunner;
    }

    private void startToCloseShop(List<Thread> threads) {
        yellowColourPrint("Shop is closing");
        joinThreads(threads);
        yellowColourPrint("Store " + store.name + " closed");
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

    public int getNumberOfCashiers() {
        return numberOfCashiers;
    }

    public void setNumberOfCashiers(int numberOfCashiers) {
        this.numberOfCashiers = numberOfCashiers;
    }
}


