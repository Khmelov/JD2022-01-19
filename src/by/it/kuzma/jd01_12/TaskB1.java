package by.it.kuzma.jd01_12;

import java.util.HashMap;
import java.util.Scanner;

public class TaskB1 {

    public static final String SYMBOL = "[^\\w-']";

    public static void main(String[] args) {

        HashMap<String, Integer> words = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true){
            String nextText = scanner.next();
            if (!nextText.equals("end")){
                nextText = nextText.replaceAll(SYMBOL,"");
                if (!nextText.equals("")){
                    if (!words.containsKey(nextText)){
                        words.put(nextText,1);
                    } else {
                        int value = words.get(nextText);
                        words.replace(nextText,value+1);
                    }
                }
            } else {
                break;
            }
        }
        System.out.println(words);
    }
}
