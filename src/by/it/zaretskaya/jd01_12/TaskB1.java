package by.it.zaretskaya.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    private static Scanner scanner;
    private static Map<String, Integer> wordsMap;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);
        wordsMap = new HashMap<>();

        fillMap(wordsMap);
        printOutMap(wordsMap);

    }

    private static void fillMap(Map<String, Integer> wordsMap) {
        while (true) {

            String text = scanner.next();
            if (!text.equals("end")) {
                Pattern pattern = Pattern.compile("[A-Za-z']+");
                Matcher matcher = pattern.matcher(text);
                while (matcher.find()) {
                    String singleWord = matcher.group();
                    if (!wordsMap.containsKey(singleWord)) {
                        wordsMap.put(singleWord, 1);
                    } else {
                        int intValue = wordsMap.get(singleWord);
                        wordsMap.put(singleWord, intValue + 1);
                    }


                }

            } else break;

        }
    }


    private static void printOutMap(Map<String, Integer> wordsMap) {

        Set<Map.Entry<String, Integer>> entries = wordsMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            String word = entry.getKey();
            Integer frequency = entry.getValue();
            System.out.printf("%s=%s%n", word, frequency);


        }
    }
}




