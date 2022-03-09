package by.it.zaretskaya.jd01_14;

import java.io.*;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    public static final String FILENAME_TO_READ = "Poem.txt";
    public static final String FILENAME_TO_WRITE = "resultTaskB.txt";
    public static final String ROOT = "src";
    public static final String WORDS = "[а-яА-ЯёЁ]+";
    public static final String PUNCTUATION_MARKS = "[\\p{Punct}]+";

    public static void main(String[] args) {

        String fileNameToRead = PathFinder.getFileName(TaskB.class, ROOT, FILENAME_TO_READ);
        File fileToRead = new File(fileNameToRead);
        StringBuilder textFromFile = new StringBuilder("");

        readFileToString(fileToRead, textFromFile); // читаем текст из файла в стрингбилдер

        int wordsCounter = countWords(textFromFile);
        int punctuationCounter = countPunctuationMarks(textFromFile);

        String output = String.format("words=%d, punctuation marks=%d", wordsCounter, punctuationCounter);

        System.out.println(output);

        String txtFileName = PathFinder.getFileName(TaskB.class, ROOT, FILENAME_TO_WRITE);
        outputToTxtFile(output, txtFileName);
    }

    public static void outputToTxtFile(String output, String txtFileName) {

        try (PrintWriter printWriter = new PrintWriter(txtFileName)) {
            printWriter.print(output);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("IO error", e);
        }
    }

    private static int countPunctuationMarks(StringBuilder textFromFile) {
        int punctuationCounter = 0;
        Pattern punctuationPattern = Pattern.compile(PUNCTUATION_MARKS);
        Matcher punctuationMatcher = punctuationPattern.matcher(textFromFile);
        while (punctuationMatcher.find()) {
            punctuationCounter++;
        }
        return punctuationCounter;
    }

    private static int countWords(StringBuilder textFromFile) {
        int wordsCounter = 0;
        Pattern wordsPattern = Pattern.compile(WORDS);
        Matcher wordsMatcher = wordsPattern.matcher(textFromFile);
        while (wordsMatcher.find()) {
            wordsCounter++;
        }
        return wordsCounter;
    }

    private static void readFileToString(File fileToRead, StringBuilder textFromFile) {
        try (FileReader fileReader = new FileReader(fileToRead)) {
            int symbol = 0;
            while ((symbol = fileReader.read()) != -1) {
                textFromFile.append((char) symbol);
            }
        } catch (IOException e) {
            throw new RuntimeException("IO error", e);
        }
    }
}
