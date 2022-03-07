package by.it.katsal.jd01_12;

import java.util.*;

public class TaskB3 {


    public static void main(String[] args) {
        ArrayList<String> players = new ArrayList<>();
        LinkedList<String> anotherPlayers = new LinkedList<>();
        Scanner scan = new Scanner(System.in);
        final int quantity = scan.nextInt();
        getFillList(players, quantity);
        getFillList(anotherPlayers,quantity);
        long startArray = System.nanoTime();
        process(players);
        long endArray = System.nanoTime();
        System.out.printf("ArraysList - %d%n", endArray - startArray);
        long startLinked = System.nanoTime();
        process(anotherPlayers);
        long endLinked = System.nanoTime();
        System.out.printf("LinkedList - %d%n", endLinked - startLinked);

    }

    static String process(ArrayList<String> peoples){
        int count = 0;
        Iterator<String> iterator = peoples.iterator();
        while(peoples.size() != 1) {
            if(iterator.hasNext()) {
                iterator.next();
                count++;
                if(count == 2) {
                    iterator.remove();
                    count = 0;;
                }
            }

            else {

                iterator = peoples.iterator();
            }
        }
        return peoples.get(0);
    }

    private static void getFillList(List<String> list, int quantity) {
        for (int i = 0; i < quantity; i++){
            list.add(i+1 + " player");
        }
    }


    static String process(LinkedList<String> peoples){
        int count = 0;
        Iterator<String> iterator = peoples.iterator();
        while(peoples.size() != 1) {
            if(iterator.hasNext()) {
                iterator.next();
                count++;
                if(count == 2) {
                    iterator.remove();
                    count = 0;;
                }
            }
            else {

                iterator = peoples.iterator();
            }
        }
        return peoples.get(0);
    }
}



