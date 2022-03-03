package by.it.kuzma.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    public static final String POEM = "Poem.txt";
    public static final String ROOT = "src";
    public static final String WORDS = "[а-яА-ЯёЁ]+";
    public static final String PUNCTUATION_MARK = "[\\p{P}]+";
    public static final String RESULT_TXT = "resultTaskB.txt";

    private static int counterWord = 0;
    private static int counterMark = 0;


    public static void main(String[] args) {


        OutputToTxt();


    }

    private static void OutputToTxt() {
        String fileName = PathFinder.getFilename(TaskB.class, ROOT, POEM);
        ReaderPoem(fileName);

        System.out.printf("words=%d, punctuation marks=%d%n", counterWord, counterMark);

        String fileTxt = PathFinder.getFilename(TaskB.class, ROOT, RESULT_TXT);


        try (PrintWriter printWriter = new PrintWriter(fileTxt)){
            printWriter.printf("words=%d, punctuation marks=%d%n", counterWord, counterMark);
        } catch (IOException e) {
            throw new RuntimeException("ERROR", e);
        }
    }

    private static void ReaderPoem(String fileName)  {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){

            String line;

            while ((line = bufferedReader.readLine()) != null){

                Pattern patternWord = Pattern.compile(WORDS);
                Matcher matcherWord = patternWord.matcher(line);

                Pattern patternMark = Pattern.compile(PUNCTUATION_MARK);
                Matcher matcherMark = patternMark.matcher(line);

                while (matcherWord.find()){
                    counterWord++;
                }
                while (matcherMark.find()){
                    counterMark++;
                }
            }
        }
         catch (IOException e) {
             throw new RuntimeException("ERROR", e);
        }
    }
}
