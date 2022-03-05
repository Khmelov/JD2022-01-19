package by.it.yushkevich.jd01_15;

import by.it.yushkevich.jd01_14.PathFinder;

import java.io.*;

public class TaskB {
    //омнономномномном
    //омомоомомомомомомом
    /*ыльфдльвдфьывдфьылвьфдлыв
    льыдфьвдыльфдлвьфд
     */
    public static final String SCR = "src";
    public static final String JAVA_FILE = "TaskB.java";
    public static final String TXT_FILE = "TaskB.txt";

    public static void main(String[] args) {

        String fileNameJava = PathFinder.getFileName(TaskB.class, SCR, JAVA_FILE);
        String fileNameTxt = PathFinder.getFileName(TaskB.class, SCR, TXT_FILE);

        String textFromJava = deleteAllComments(fileNameJava);

        printToConsole(textFromJava);
        printToFileTxt(textFromJava, fileNameTxt);

    }



    private static String deleteAllComments(String fileNameJava) {

        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder result = new StringBuilder();


        try (
                BufferedReader reader = new BufferedReader(new FileReader(fileNameJava));

        ) {
            String text;
            while ((text = reader.readLine()) != null) { // пока не закончится текст, мы построчно добавляем в стрингбилдер
                stringBuilder.append(text + "\n");

                int start = 0;
                int end = 0;
                boolean isStartFound = false;


                for (int i = 0; i < stringBuilder.length() - 1; i++) {
                    if (stringBuilder.charAt(i) == '/' && stringBuilder.charAt(i + 1) == '*') {
                        start = i;
                    }
                    if (stringBuilder.charAt(i) == '*' && stringBuilder.charAt(i + 1) == '/') {
                        end = i + 2;
                        stringBuilder.delete(start, end);
                    }

                    else {
                        if (stringBuilder.charAt(i) == '/' && stringBuilder.charAt(i + 1) == '/') {
                            start = i;
                            isStartFound = true;
                        }
                        if (stringBuilder.charAt(i) == '\n' && isStartFound) {
                            end = i++;
                            stringBuilder.delete(start, end);
                        }
                    }
                }

            }
            /* как-то так
            вот так вот */

        } catch (IOException e) {
            throw new RuntimeException("IO exception", e);
        }
        return stringBuilder.toString();

    }

    private static void printToConsole(String javaFileContent) {
        System.out.println(javaFileContent);
        System.out.println();
    }

    private static void printToFileTxt(String textFromJava, String filename) {
        try (PrintWriter printWriter = new PrintWriter(filename)) {
            printWriter.printf("%s%n", textFromJava);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Smth went wrong", e);
        }
    }
}
