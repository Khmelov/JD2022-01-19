package by.it.kuzma.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    public static final char[] lettersCon = {'й', 'ц', 'к', 'н', 'г', 'ш', 'щ', 'з', 'х', 'ф',
                                            'в',  'п', 'р', 'л', 'д', 'ж', 'б', 'т', 'м', 'с', 'ч'};
    public static final char[] lettersVal = {'а', 'у', 'о', 'ы', 'и', 'э', 'я', 'ю', 'ё', 'е'};
    public static final String RU_LETTER = "[А-Яа-яЁё]+";

    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile(RU_LETTER);
        Matcher matcher = pattern.matcher(stringBuilder);

        while (matcher.find()){
            String word = matcher.group();
            checkWord(word);
        }
    }

    private static void checkWord(String word) {

        char firstLetter = word.toLowerCase().charAt(0);
        char lastLetter = word.charAt(word.length()-1);

        for (char letter : lettersCon) {
            if (letter == firstLetter){
                for (char letter2 : lettersVal) {
                    if (letter2 == lastLetter) {
                        System.out.println(word);
                    }
                }

            }
        }


    }
}
