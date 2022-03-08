package by.it.chaikova.jd01_12;

import java.util.*;

public class TaskB2 {

    public static void main(String[] args) {

        ArrayList<String> peopleArrayList = new ArrayList<>();
        LinkedList<String> peopleList= new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            peopleArrayList.add("n" + i);
            peopleList.add("n" + i);
        }
    }

    static String process(LinkedList<String> peoples) {
        while (peoples.size() > 1) {
            for (int i = 1; i < peoples.size(); i++) {
                if (i % 2 == 0) {
                    peoples.remove(i);
                }
            }
        }
        return null;
    }

    static String process(ArrayList<String> peoples) {
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            for (int i = 1; iterator.hasNext(); i++, iterator.next()) {
                if (i % 2 == 1) {
                    i = 0;
                    iterator.remove();
                }
    /*static String process(ArrayList<String> peoples) {

        ArrayList<Integer> num = new ArrayList<>();
        for (int i = 1; i < num.size() + 1; i++) {
            num.add(i);
        }
        int i = 0;
        int size = 0;
        while (num.size() > 1) {
            if (num.size() % 2 != 0) {
                i = 0;
                size = num.size() / 2;
                for (int j = 0; j < size; j++) {
                    num.remove(i + 1);
                    i++;
                }
                num.remove(0);
            } else if (num.size() % 2 == 0) {
                i = 0;
                size = num.size() / 2;
                for (int j = 0; j < size; j++) {
                    num.remove(i + 1);
                    i++;
                }
            }
        }
        System.out.println(num.get(0));
        return null;
    }*/
            }
        }
        return null;
    }
}

