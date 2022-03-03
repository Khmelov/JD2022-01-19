package by.it.kuzma.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class TaskB2 {
    public static void main(String[] args) {

        ArrayList<String> peoplesInArray = new ArrayList<>();
        LinkedList<String> peoplesInLinked = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            peoplesInArray.add(Integer.toString(i));
            peoplesInLinked.add(Integer.toString(i));
        }

        System.out.println("Survivor in ArrayList: "+ process(peoplesInArray));
        System.out.println("Survivor in LinkedList: "+ process(peoplesInLinked));

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
}
