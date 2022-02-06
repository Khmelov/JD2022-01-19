package by.it.kharevich.jd01_06;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaskB1 {

    private static String[] words = {};
    private static final char[] symbol = {'а', 'у', 'о', 'ы', 'и', 'э', 'я', 'ю', 'ё', 'е'};

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(by.it.kharevich.jd01_06.Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            processOneWord(word);
        }
        printResult();
    }


    private static void processOneWord(String word) {
        char firstLetter = word.charAt(0);
        char lastLetter = word.charAt(word.length() - 1);
        for (char c : symbol) {
            if (c != (Character.toLowerCase(firstLetter)) && (c == lastLetter) && word.length() > 1) {
                words = Arrays.copyOf(words, words.length + 1);
                words[words.length - 1] = word;
            }
        }
    }

    private static void printResult() {
        for (String word : words) {
            System.out.printf("%s\n", word);
        }
    }


}
