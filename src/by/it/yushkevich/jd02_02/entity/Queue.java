package by.it.yushkevich.jd02_02.entity;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.Optional;

public class Queue {

    private final Deque<Customer> customerDeque = new ArrayDeque<>();
  //  private final Object monitor = new Object();

    public synchronized void add(Customer customer) {
       // synchronized (this) { можно по разному синзронизироваться
            customerDeque.addLast(customer);//добавляем в конец очереди
        //}
    }

    public synchronized Optional<Customer> extract(){ // метод извлекает из очеред кастомера
        //Optional<> на потоках то ли null то ли не null , мы не знаем
        //synchronized (this) {
            return Optional.ofNullable(customerDeque.pollFirst());
        //}


    }

}
