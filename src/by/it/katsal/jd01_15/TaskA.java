package by.it.katsal.jd01_15;
import by.it.katsal.jd01_14.PathFinder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA {

    public static final String MATRIX_TXT = "matrix.txt";
    public static final String ROOT = "src";

    public static void main(String[] args) {

        String filename = PathFinder.getFilename(TaskA.class, "src", "matrix.txt");

        int[][] matrix = generateMatrix(6, 4, -15, 15);

        saveToTXT(matrix, filename);

        List<String> strings = getStrings(filename);

        printToConsole(strings);

    }

    private static void printToConsole(List<String> strings) {

        for (String string : strings) {
            System.out.println(string);
        }
    }

    private static List<String> getStrings(String filename) {

        try {
            return Files.readAllLines(Paths.get(filename));
        } catch (IOException e) {
            throw new RuntimeException("IO exception", e);
        }
    }


    private static int[][] generateMatrix(int rows, int columns, int leftBorder, int rightBorder) {

        int[][] returnMatrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                returnMatrix[i][j] = ThreadLocalRandom.current().nextInt(leftBorder, rightBorder + 1);
            }
        }
        return returnMatrix;
    }

    private static void saveToTXT(int[][] matrix, String filename) {

        try (
                PrintWriter printWriter = new PrintWriter(filename)
        ) {
            for (int[] ints : matrix) {
                for (int anInt : ints) {
                    printWriter.printf("%3d ", anInt);
                }
                printWriter.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}


