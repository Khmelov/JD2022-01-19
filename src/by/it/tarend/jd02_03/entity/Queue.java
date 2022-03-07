package by.it.tarend.jd02_03.entity;


import java.util.Optional;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;


public class Queue {


    private final BlockingDeque<Customer> customerDeque = new LinkedBlockingDeque<>(30);

    public void add(Customer customer){
        try {
            customerDeque.putLast(customer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Optional<Customer> extract() {
        return Optional.ofNullable(customerDeque.pollFirst());
    }
}
