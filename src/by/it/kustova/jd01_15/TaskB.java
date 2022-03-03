package by.it.kustova.jd01_15;

import by.it.kustova.jd01_14.PathFinder;

import java.io.*;


public class TaskB {
    public static final String ROOT = "src";
    public static final String TASK_B_JAVA = "TaskB.java";
    public static final String TASK_B_TXT = "TaskB.txt";

    //oneLine comment

    /* additional
    comment
     */


    /**
     * метод main() точка входа
     */

    public static void main(String[] args) {

        String filename = PathFinder.getFilename(TaskB.class, ROOT, TASK_B_JAVA);
        String filename1 = PathFinder.getFilename(TaskB.class, ROOT, TASK_B_TXT);

        String javaFile = readFileAndDeleteComments(filename);

        writeToTxtFile(filename1, javaFile);

        readAndPrintTxtFile(filename1);


    }

    private static void readAndPrintTxtFile(String filename1) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename1))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToTxtFile(String filename1, String javaFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename1))) {
            bufferedWriter.write(javaFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFileAndDeleteComments(String filename) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String text;
            while ((text = reader.readLine()) != null) {
                stringBuilder.append(text + "\n");
            }
            int start = 0;
            int end;
            for (int i = 0; i < stringBuilder.length(); i++) {
                if (stringBuilder.charAt(i) == '/' && stringBuilder.charAt(i + 1) == '*') {
                    start = i;
                } else if (stringBuilder.charAt(i) == '*' && stringBuilder.charAt(i + 1) == '/') {
                    end = i++ + 2;
                    stringBuilder.replace(start, end, " ");
                }
            }
            for (int i1 = 0; i1 < stringBuilder.length() ; i1++) {
                if (stringBuilder.charAt(i1) == '/' && stringBuilder.charAt(i1 + 1) == '/') {
                    start = i1;
                } else if (stringBuilder.charAt(i1) == ' ' && stringBuilder.charAt(i1+1) == '\n') {
                    end = i1++ +2;
                    stringBuilder.replace(start, end, " ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}



