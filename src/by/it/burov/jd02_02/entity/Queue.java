package by.it.burov.jd02_02.entity;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;

public class Queue {

    private final Deque<Customer> customerDeque = new ArrayDeque<>();

    public synchronized void add(Customer customer) {
        customerDeque.addLast(customer);
    }

    public synchronized Optional<Customer> extract() {
        return Optional.ofNullable(customerDeque.pollFirst());
    }
}
