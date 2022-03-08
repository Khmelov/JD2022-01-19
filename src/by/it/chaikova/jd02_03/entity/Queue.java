package by.it.chaikova.jd02_03.entity;


import by.it.chaikova.jd02_03.utils.Constants;
import by.it.chaikova.jd02_04.exceptions.ApplacitionException;

import java.util.Optional;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Queue {
    private final BlockingDeque<Customer> customerDeque = new LinkedBlockingDeque<>(
            Constants.QUEUE_CUSTOMER_LENGTH
    );
    //private final Object monitor = new Object();


    public void add(Customer customer) {
       // synchronized (monitor) {

            customerDeque.addLast(customer);
       // }
    }

    public Optional<Customer> extact() {
       // synchronized (monitor) {
        try {
            return Optional.ofNullable(customerDeque.pollFirst(1, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            throw new ApplacitionException(e);
        }
        // }
    }
}