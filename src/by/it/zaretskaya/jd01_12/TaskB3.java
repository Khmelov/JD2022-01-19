package by.it.zaretskaya.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB3 {


    private static final int COUNT = 100;
    private static int counterArr;
    private static int counterLink;

    public static void main(String[] args) {

        ArrayList<String> peoplesArrayList = new ArrayList<>();
        LinkedList<String> peoplesLinkedList = new LinkedList<>();

        fillingList(peoplesArrayList, peoplesLinkedList);

        long startArr = (System.nanoTime());
        process(peoplesArrayList);
        long endARR = (System.nanoTime());
        long deltaArr = (endARR - startArr) / 1000;

        long startLink = (System.nanoTime());
        process(peoplesLinkedList);
        long endLink = (System.nanoTime());
        long deltaLink = (endLink - startLink) / 1000;

        System.out.println("ArrayList --- " + deltaArr + " микросекунд");
        System.out.println("LinkedList --- " + deltaLink + " микросекунд");


    }

    private static void fillingList(ArrayList<String> peoplesArrayList, LinkedList<String> peoplesLinkedList) {
        for (int i = 10; i <= COUNT; i++) {
            peoplesArrayList.add("[Num " + i + "]");
            peoplesLinkedList.add("[Num " + i + "]");
        }
    }


    static String process(ArrayList<String> peoples) {

        Iterator<String> iterator = peoples.iterator();

        while (iterator.hasNext()) {
            iterator.next();
            counterArr++;

            if (counterArr % 2 == 0) {
                iterator.remove();
            }

        }
        if (peoples.size() > 1) {
            process(peoples);
        }
        counterArr = 0;


        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples) {

        Iterator<String> iterator = peoples.iterator();

        while (iterator.hasNext()) {
            iterator.next();
            counterLink++;

            if (counterLink % 2 == 0) {
                iterator.remove();
            }

        }
        if (peoples.size() > 1) {
            process(peoples);
        }
        counterLink = 0;


        return peoples.get(0);
    }


}
