package by.it.skorobogatyi.jd02_02.entity;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;

public class ShopQueue {

    private volatile Deque<Customer> customerDeque = new ArrayDeque<>();

    public synchronized void add(Customer customer) {
        customerDeque.addLast(customer);
    }

    public synchronized Optional<Customer> extract() {
        return Optional.ofNullable(customerDeque.pollFirst());
    }

    public synchronized int size() {
        return customerDeque.size();
    }
}
