package by.it.burov.jd02_02.services;

import by.it.burov.jd02_02.entity.*;
import by.it.burov.jd02_02.utils.RandomData;
import by.it.burov.jd02_02.utils.Sleeper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class CashierWorker implements Runnable {
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
        while (!manager.storeIsClosed()) {
            Optional<Customer> optionalCustomer = queue.extract();
            if (optionalCustomer.isPresent()) {
                Customer customer = optionalCustomer.get();
                cashierWork(customer);
                synchronized (customer.getMonitor()) {
                    customer.setWaiting(false);
                    customer.notify();
                }
            } else {
                Sleeper.sleep(100);

            }
        }
        BigDecimal dayIncome = cashier.getIncome();
        System.out.println("\t" + cashier + " finished : income " + dayIncome.toString());
    }

    private void cashierWork(Customer customer) {
        System.out.println("\t" + cashier + " start service " + customer);
        int timeout = RandomData.get(2000, 5000);
        Sleeper.sleep(timeout);
        List<Good> goods = customer.getShoppingCart().goodsInCart;
        BigDecimal sumPurchase = BigDecimal.valueOf(0);
        StringBuilder purchases = new StringBuilder();
        purchases.append("-".repeat(30)).append("\n");
        purchases.append("Check for ").append(customer).append('\n');
        for (Good good : goods) {
            purchases.append(good.name).append(" = ").append(good.price).append("BYN").append("\n");
            sumPurchase = sumPurchase.add(good.price);
        }
        purchases.append("SUM:").append(" ".repeat(15)).append(sumPurchase).append("\n");
        purchases.append("-".repeat(30)).append("\n");
        cashier.setIncome(cashier.getIncome().add(sumPurchase));
        System.out.println("\t" + cashier + " finished service " + customer);
        System.out.println(purchases.toString());
    }
}
