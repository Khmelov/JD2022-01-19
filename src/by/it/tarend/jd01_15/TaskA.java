package by.it.tarend.jd01_15;

import by.it.tarend.jd01_14.PathFinder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA {

    public static final String ROOT = "src";
    public static final String FILENAME_TO_WRITE = "matrix.txt";

    public static void main(String[] args) {
        int[][] matrix = createMatrix(6, 4, -15, 15);
        String fileName = PathFinder.getFileName(TaskA.class, ROOT, FILENAME_TO_WRITE);

        saveMatrixToTxtFile(matrix, fileName);
        List<String> strings = getTextFromTxtFile(fileName);
        printToConsole(strings);

    }

    private static void printToConsole(List<String> strings) {
        for (String line : strings) {
            System.out.println(line);
        }
    }

    private static List<String> getTextFromTxtFile(String fileName) {
        try {
            return Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            throw new RuntimeException("IO error" + fileName, e);
        }
    }

    private static void saveMatrixToTxtFile(int[][] matrix, String fileName) {
        try (PrintWriter printWriter = new PrintWriter(fileName)) {
            for (int[] row : matrix) {
                for (int element : row) {
                    printWriter.printf("%3d ", element);
                }
                printWriter.println();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException("IO error" + fileName, e);
        }
    }

    @SuppressWarnings("SameParameterValue")
    private static int[][] createMatrix(int rows, int columns, int minValue, int maxValue) {
        int[][] matrix = new int[rows][columns];
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                row[i] = minValue + ThreadLocalRandom.current().nextInt(maxValue - minValue + 1); //  случайное число от -15 до 15
            }
        }
        return matrix;
    }
}
