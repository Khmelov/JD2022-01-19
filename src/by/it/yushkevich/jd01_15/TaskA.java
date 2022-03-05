package by.it.yushkevich.jd01_15;

import by.it.yushkevich.jd01_14.PathFinder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA {

    public static void main(String[] args) {
        int[][] matrix = createMatrix(6, 4, -15, 15);
        String fileName = PathFinder.getFileName(TaskA.class, "src", "matrix.txt");
        save(matrix, fileName);
        List<String> list = getStrings(fileName);
        printToConsole(list);

    }

    private static void printToConsole(List<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }

    private static List<String> getStrings(String fileName) {

        try {
           return Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            throw new RuntimeException("IO exception "+fileName, e);
        }
    }

    private static void save(int[][] matrix, String fileName) {
        try (PrintWriter printWriter = new PrintWriter(fileName)) { //поток на запись с форматирование - принтрайтер
            for (int[] row : matrix) {
                for (int element = 0; element < row.length; element++) {
                    printWriter.printf("%3d ", row[element]);
                }
                printWriter.println();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static int[][] createMatrix(int rows, int cols, int minValue, int maxValue) {
        int[][] array = new int[rows][cols];

        for (int[] row : array) {
            for (int i = 0; i < row.length; i++) {
                row[i] = minValue + ThreadLocalRandom.current().nextInt(maxValue - minValue + 1);

            }

        }

        return array;
    }
}
