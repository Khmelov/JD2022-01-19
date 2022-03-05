package by.it.kuzma.jd01_12;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class TaskB3 {
    public static void main(String[] args) {

        ArrayList<String> peoplesInArray = new ArrayList<>();
        LinkedList<String> peoplesInLinked = new LinkedList<>();

        int n = 4096;
        for (int i = 1; i <= n; i++) {
            peoplesInArray.add(Integer.toString(i));
            peoplesInLinked.add(Integer.toString(i));
        }

        Instant startTimeArray = Instant.now();
        System.out.println("Survivor in ArrayList: "+ process(peoplesInArray));
        Instant finishTimeArray = Instant.now();
        long durationArray = Duration.between(startTimeArray, finishTimeArray).toMillis();
        System.out.println("Duration ArrayList: " + durationArray + "ms");

        Instant startTimeLinked = Instant.now();
        System.out.println("Survivor in LinkedList: "+ process(peoplesInLinked));
        Instant finishTimeLinked = Instant.now();
        long durationLinked = Duration.between(startTimeLinked, finishTimeLinked).toMillis();
        System.out.println("Duration Deque LinkedList: " + durationLinked + "ms");

    }

    static String process(ArrayList<String> peoples){

        int counter = 0;
        while (peoples.size() > 1){
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()){
                iterator.next();
                counter++;
                if (counter % 2 == 0){
                    iterator.remove();
                }
            }
        }
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples){

        while (1 < peoples.size()){
                ((Deque<String>) peoples).addLast(peoples.pop());
                ((Deque<String>) peoples).remove(peoples.getFirst());
            }
        return peoples.get(0);
    }
}
