package by.it.chaikova.jd02_02.entity;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;

public class Queue {
    private final Deque<Customer> customerDeque = new ArrayDeque<>();
    private final Object monitor = new Object();


    public void add(Customer customer) {
        synchronized (monitor) {

            customerDeque.addLast(customer);
        }
    }

    public Optional<Customer> extact() {
        synchronized (monitor) {
            return Optional.ofNullable(customerDeque.pollFirst());
        }
    }
}