package by.it.skorobogatyi.jd02_03.services;

import by.it.skorobogatyi.jd02_03.entity.*;
import by.it.skorobogatyi.jd02_03.utils.RandomData;
import by.it.skorobogatyi.jd02_03.utils.Sleeper;

import java.util.concurrent.atomic.AtomicInteger;

import static by.it.skorobogatyi.jd02_02.utils.ColouredPrinter.yellowColourPrint;

public class StoreRunner extends Thread {

    public final Store store;
    private final AtomicInteger numberOfCashiers = new AtomicInteger(0);

    public StoreRunner(Store store) {
        this.store = store;
    }

    @Override
    public void run() {

        yellowColourPrint("Store " + store.name + " opened");

        int customerNumber = 0;
        int minuteOfRun = 0;

        Manager managerOfThisStore = store.getManager();
        getAndRunManager(this);

        while (managerOfThisStore.shopOpened()) {

            int secondOfRun = customerNumber;

            if (secondOfRun == 60) {
                secondOfRun = 0;
                minuteOfRun++;
            }

            int numberOfGeneratedCustomers = RandomData.getRandomNumber(100, 1000);
            int numberOfActualCustomers = getNumberOfActualCustomers();


            for (int i = 0; i < numberOfGeneratedCustomers && managerOfThisStore.shopOpened(); i++) {

                if (definePhaseOfShopWork(secondOfRun)) {
                    if (numberOfActualCustomers <= secondOfRun - minuteOfRun * 60 + 10) {
                        generateAndRunNewCustomerRunner(++customerNumber);
                    }
                } else {
                    if (numberOfActualCustomers <= 40 + (30 - secondOfRun + minuteOfRun * 60)) {
                        generateAndRunNewCustomerRunner(++customerNumber);
                    }
                }

                Sleeper.sleep(1000);
            }
        }
        yellowColourPrint("Store " + store.name + " closed");
    }

    private int getNumberOfActualCustomers() {
        return store.getManager().getCustomerIn().get() - store.getManager().getCustomerOut().get();
    }

    private boolean definePhaseOfShopWork(int secondOfRun) {
        double tempResult = (double) secondOfRun / 60;
        double finalResult = tempResult % 1;
        return finalResult < 0.5;
    }

    private void getAndRunManager(StoreRunner storeRunner) {
        ManagerRunner managerRunner = new ManagerRunner(store, storeRunner);
        managerRunner.start();
    }


    private void generateAndRunNewCustomerRunner(int customerNumber) {
        CustomerRunner customerRunner = generateNewCustomerRunner(customerNumber);
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

    public int getNumberOfCashiers() {
        return numberOfCashiers.get();
    }

    public void setNumberOfCashiers(int numberOfCashiers) {
        this.numberOfCashiers.set(numberOfCashiers);
    }
}


