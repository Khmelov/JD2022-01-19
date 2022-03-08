package by.it.tarend.jd02_02.services;

import by.it.tarend.jd02_02.entity.*;
import by.it.tarend.jd02_02.utils.PriceListRepo;
import by.it.tarend.jd02_02.utils.RandomData;
import by.it.tarend.jd02_02.utils.Sleeper;

import java.util.Optional;

public class CashierWorker implements Runnable{


    private final Cashier cashier;
    private final Store store;

    public CashierWorker(Cashier cashier, Store store) {
        this.cashier = cashier;
        this.store = store;
    }


    @Override
    public void run() {
        System.out.println("\t" + cashier + " started");
        Manager manager = store.getManager();
        Queue queue = store.getQueue();

        while (!manager.shopClosed()){
            Optional<Customer> optionalCustomer = queue.extract();
            if (optionalCustomer.isPresent()) {
                Customer customer = optionalCustomer.get();
                System.out.println("\t" + cashier + " start service " + customer);
                int timeOut = RandomData.get(2000, 5000);
                Sleeper.sleep(timeOut);
                serveCustomer(customer);
                System.out.println("\t" + cashier + " finished service " + customer);
                synchronized (customer.getMonitor()) {
                    customer.setWaiting(false);
                    customer.notify();
                }
            } else {
                Sleeper.sleep(100);
            }
        }
        System.out.println("\t" + cashier + " finished");
        System.out.println("\tTotal for " + cashier + " = " + cashier.cashRegister);

    }

    private void serveCustomer(Customer customer) {
            StringBuilder bill = new StringBuilder();
            String billHead = "\n------- Bill for " + customer + "-------\n";
            bill.append(billHead);
            for (Good good : customer.getShoppingCart().goodsInCart) {
                Double goodPrice = PriceListRepo.priceList.get(good);
                customer.bill += goodPrice;
                cashier.cashRegister += goodPrice;
                String position = "\t" + good + "\n";
                bill.append(position);
            }
            String billTotal = "\tTotal for " + customer + " = " + customer.bill + "\n";
            bill.append(billTotal);
            System.out.println(bill);
    }
}
