package by.it.zaretskaya.jd01_15;

import by.it.zaretskaya.jd01_14.PathFinder;

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
        int[][]matrix=createMatrix(6,4,-15,15);
        String fileName = PathFinder.getFileName(TaskA.class, ROOT, MATRIX_TXT);
        save2DArrayToTxtFile(matrix,fileName);
        List<String> strings = getStringsFromTxtFile(fileName);
        printToConsole
                (strings);
    }


    private static void printToConsole(List<String> strings) {
        for (String string : strings) {
            System.out.println(string);
        }
    }

    private static List<String> getStringsFromTxtFile(String fileName) {
        try {
            return Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("IO error: "+fileName,e);
        }
    }

    private static void save2DArrayToTxtFile(int[][] matrix, String fileName) {
       try (PrintWriter printWriter = new PrintWriter(fileName)){
           for (int[] row : matrix) {
               for (int element : row) {
                printWriter.printf("%3d ",element);
               }
               printWriter.println();
           }
       } catch (FileNotFoundException e) {
           throw new RuntimeException("IO error: "+fileName,e);
       }
    }

    @SuppressWarnings("SameParameterValue")
    private static int[][] createMatrix(int rows, int cols, int minValue, int maxValue) {
        int[][] array = new int[rows][cols];
        for (int[] row:array){
            for (int i = 0; i < row.length; i++) {
                row[i]=minValue+ThreadLocalRandom.current().nextInt(maxValue-minValue+1);

            }
        }
        return array;
    }
}
