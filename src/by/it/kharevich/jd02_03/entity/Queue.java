package by.it.kharevich.jd02_03.entity;

import by.it.kharevich.jd02_03.exceptions.StoreException;
import by.it.kharevich.jd02_03.utils.Constants;

import java.util.Optional;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Queue {

    private final BlockingDeque<Customer> customerDeque = new LinkedBlockingDeque<>(
            Constants.QUEUE_CUSTOMER_LENGTH);

    public void add(Customer customer) {
        customerDeque.addLast(customer);
    }

    public Optional<Customer> extract() {
        try {
            return Optional.ofNullable(customerDeque.pollFirst(3, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            throw new StoreException(e);
        }
    }
}
