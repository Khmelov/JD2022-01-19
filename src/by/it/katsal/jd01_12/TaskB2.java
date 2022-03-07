package by.it.katsal.jd01_12;

import java.util.*;

public class TaskB2 {


    public static void main(String[] args) {
        ArrayList<String> players = new ArrayList<>();
        LinkedList<String> anotherPlayers = new LinkedList<>();
        Scanner scan = new Scanner(System.in);
        final int quantity = scan.nextInt();
        getFillList(players, quantity);
        getFillList(anotherPlayers,quantity);
        System.out.println(players);
        process(players);
        System.out.println(anotherPlayers);
        process(anotherPlayers);
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

