package by.it.zaretskaya.jd02_03.entity;

import by.it.zaretskaya.calculator.exeptions.ApplicationException;
import by.it.zaretskaya.jd02_03.utils.Constants;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Queue {
    private final BlockingDeque<Customer>customerDeque=new LinkedBlockingDeque<>(
            Constants.QUEUE_CUSTOMER_LENGTH
    );


    public  void add(Customer customer){

        customerDeque.addLast(customer);
        }

    public  Optional<Customer> extract(){

        try {
            return Optional.ofNullable(customerDeque.pollFirst(5, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            throw new ApplicationException(e);
        }
    }
}
