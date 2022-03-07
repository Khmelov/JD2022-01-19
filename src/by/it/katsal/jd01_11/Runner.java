package by.it.katsal.jd01_11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        processListA(list);
        list = new ListA<>();
        processListA(list );
    }

    private static void processListA(List<String> list) {
        System.out.printf("======%s========%n", list.getClass().getSimpleName() );
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        String first = list.get(0);
        String last = list.get(3);
        System.out.printf("first = %s last = %s%n",first, last );
    }
    private static void processListB() {
        System.out.println("-".repeat(10) + "Start processing ListB" + "-".repeat(10));

        ListB myList =  new ListB();
        myList.add("one");
        myList.add("two");
        myList.add("three");
        myList.add("four");
        myList.add("five");
        System.out.println(myList);

        myList.remove(2);
        System.out.println(myList);

        String first = (String) myList.get(0);
        String last = (String) myList.get(myList.size() - 1);
        System.out.printf("first = %s, last = %s%n", first, last);

        myList.set(3, "new");
        System.out.println(myList + "(new element in cell 3)");

        myList.add(0, "zero");
        System.out.println(myList + "(new element in cell 0)");

        String[] forAdding = {"another", "and another", "aaaaand another"};
        myList.addAll(List.of(forAdding));
        System.out.println(myList + "(new elements with addAll)");
        System.out.println("-".repeat(10) + "End processing ListB" + "-".repeat(10));
        System.out.println();
    }

}



