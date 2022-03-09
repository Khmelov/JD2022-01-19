package by.it.zaretskaya.jd01_14;


import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA {

    public static final String FILENAME_BINARY = "dataTaskA.bin";
    public static final String FILENAME_TXT = "resultTaskA.txt";
    public static final String ROOT = "src";

    public static void main(String[] args) {
        // получили путь к файлу
        String fileName = PathFinder.getFileName(TaskA.class, ROOT, FILENAME_BINARY);
        // запись в бинарный файл
        writeBinaryFile(fileName);
        // читаем бинарный файл и записываем числа из него в массив
        ArrayList<Integer> listOfIntegers = readBinaryFile(fileName);
        // вывод в консоль
        outputConsole(listOfIntegers);
        // вывод в txt
        String txtFileName = PathFinder.getFileName(TaskA.class, ROOT, FILENAME_TXT);
        outputToTxtFile(listOfIntegers, txtFileName);
    }

    private static void writeBinaryFile(String fileName) {
        try (
                DataOutputStream dataOutputStream = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(fileName)))
        ) {
            for (int i = 0; i < 20; i++) {
                int value = ThreadLocalRandom.current().nextInt(2000);
                dataOutputStream.writeInt(value);

            }

        } catch (IOException e) {
            throw new RuntimeException("IO error", e); // (message, cause)
        }
    }

    private static ArrayList<Integer> readBinaryFile(String fileName) {
        ArrayList<Integer> listOfIntegers = new ArrayList<>();
        try (
                DataInputStream dataInputStream = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(fileName)))
        ) {
            while (dataInputStream.available() > 0) {
                int value = dataInputStream.readInt();
                listOfIntegers.add(value);
            }
        } catch (IOException e) {
            throw new RuntimeException("IO error", e);
        }
        return listOfIntegers;
    }

    private static void outputConsole(ArrayList<Integer> listOfIntegers) {
        double sum = 0;
        for (Integer integer : listOfIntegers) {
            System.out.print(integer + " ");
            sum += integer;
        }
        System.out.printf(Locale.ENGLISH, "%navg=%f%n", sum/ listOfIntegers.size());
    }

    private static void outputToTxtFile(ArrayList<Integer> listOfIntegers, String txtFileName) {

        try (PrintWriter printWriter = new PrintWriter(txtFileName)
        ) {
            double sum2 = 0;
            for (Integer integer : listOfIntegers) {
                printWriter.print(integer + " ");
                sum2 += integer;
            }
            printWriter.printf(Locale.ENGLISH, "%navg=%f%n", sum2/ listOfIntegers.size());

        } catch (FileNotFoundException e) {
            throw new RuntimeException("IO error", e);
        }
    }
}
