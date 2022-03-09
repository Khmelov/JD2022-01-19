package by.it.kustova.jd02_03.entity;

import by.it._classwork_.calculator.exceptions.ApplacitionException;
import by.it.kustova.jd02_03.utils.Constants;

import java.util.Optional;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Queue {

    private final BlockingDeque<Customer> customerDeque = new LinkedBlockingDeque<>(
            Constants.QUEUE_CUSTOMER_LENGTH
    );


    public void add(Customer customer) {
        customerDeque.addLast(customer);

    }

    public Optional<Customer> extract() {
        try {
            return Optional.ofNullable(customerDeque.pollFirst(4, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            throw new ApplacitionException(e);
        }

    }
}
