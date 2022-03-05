package by.it.kuzma.jd01_12;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> integer = new ArrayList<>();

        int positionZero = 0;

        while (true){
            String word = scanner.next();
            if (!word.equals("end")){
                int value = Integer.parseInt(word);
                if (value==0){
                    integer.add(positionZero,value);
                }else if (value>0){
                    integer.add(positionZero++,value);
                }else {
                    integer.add(value);
                }
            } else {
            break;
            }
        }
        System.out.println(integer);
    }
}
