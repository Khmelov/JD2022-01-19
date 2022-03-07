package by.it.katsal.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> words = new HashMap<>();
        while (true) {

            String sentence = scan.nextLine();
            if (!sentence.equals("end")) {
                Pattern pattern = Pattern.compile("[\\w'-]+");
                Matcher matcher = pattern.matcher(sentence);
                while (matcher.find()) {
                    String word = matcher.group();
                    if (!words.containsKey(word)) {
                        words.put(word, 1);
                    } else {
                        int value = words.get(word);
                        words.replace(word, value + 1);
                    }
                }
            } else {


                break;
            }
        }

        Set<Map.Entry<String, Integer>> set = words.entrySet();
        for (Map.Entry<String, Integer> word : set) {
                System.out.printf("%s=%s%n",word.getKey(), word.getValue());
        }
    }
}



