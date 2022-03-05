package by.it.katsal.jd01_12;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> integers = new ArrayList<>();
        int positionZero=0;
        for(;;){
            String word = sc.next();
            if (!word.equals("end")) {
                int value = Integer.parseInt(word);
                if(value==0){
                    integers.add(positionZero,value );
                } else if (value>0){
                    integers.add(positionZero++, value  );

                }
                else {
                    integers.add(value);
                }

            } else {
                break;
            }

        }
        System.out.println(integers );
    }
}



