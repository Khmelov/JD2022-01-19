package by.it.skorobogatyi.jd02_03.entity;

import by.it.skorobogatyi.jd02_03.utils.Constants;

import java.util.Optional;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class ShopQueue {

    private final BlockingDeque<Customer> customerDeque = new LinkedBlockingDeque<>(
            Constants.QUEUE_CAPACITY);

    public void add(Customer customer) {
        customerDeque.addLast(customer);
    }

    public Optional<Customer> extract() {
        return Optional.ofNullable(customerDeque.pollFirst());
    }

    public int size() {
        return customerDeque.size();
    }
}
